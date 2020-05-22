import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class RestMultiAggregation extends CamelTestSupport {

    Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:start")
                        .setHeader("CamelHttpMethod", constant("GET"))
                        .loop(body())
                        .enrich("https4://cat-fact.herokuapp.com/facts/random",
                                (oldExchange, newExchange) -> {
                                    if (newExchange == null) {
                                        return oldExchange;
                                    }
                                    String prev = oldExchange.getIn().getBody(String.class);
                                    String curr = newExchange.getIn().getBody(String.class);
                                    String body = prev + "\n" + curr;
                                    oldExchange.getIn().setBody(body);
                                    return oldExchange;
                                })
                        .end()
                        .to("mock:result");
            }
        };
    }

    @Test
    public void testMultipleRestCalls() throws InterruptedException {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMessageCount(1);
        template.sendBody("direct:start", "3");
        String aggregatedResponse = mock.getExchanges().get(0).getIn().getBody(String.class);
        log.info("Aggregated response: {}", aggregatedResponse);
        assertMockEndpointsSatisfied();
    }
}