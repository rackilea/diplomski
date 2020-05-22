import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;

public class DummyTest extends CamelTestSupport{
    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder(){
            @Override
            public void configure() throws Exception {

                from("direct://start")
                    .routeId("myroute")
                    .onException(Exception.class)
                        .id("myException")
                        .continued(true)
                    .end()
                    .throwException(new Exception())
                    .to("mock:end");
            }
        };
    }

    @org.junit.Test
    public void doTest() throws Exception{
        context.getRouteDefinition("myroute").adviceWith(context, new AdviceWithRouteBuilder(){
            @Override
            public void configure() throws Exception {
                context.getRouteDefinition("myroute")
                    .onException(Exception.class).setBody(constant("adviceWith")).continued(true);
            }});
        context.start();
        template.sendBody("direct://start", "original");
        String bodyAtEndOfExchange = getMockEndpoint("mock:end")
                .getExchanges().get(0).getIn().getBody(String.class);
        assertEquals("adviceWith", bodyAtEndOfExchange);        
        context.stop();
    }

    @Override
    public boolean isUseAdviceWith() {
        return true;
    }
}