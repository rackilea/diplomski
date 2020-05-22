import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class App1 {
    public static void main(String[] args) throws Exception {
        CamelContext first = new DefaultCamelContext();
        first.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("timer:start").to("netty4:tcp://127.0.0.1:9999?transferExchange=true");
            }
        });

        first.start();
        Thread.sleep(100000);
    }
}