import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class App2 {
    public static void main(String[] args) throws Exception {
        CamelContext second = new DefaultCamelContext();
        second.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("netty4:tcp://127.0.0.1:9999?transferExchange=true").log("Message received");
            }
        });

        second.start();

        Thread.sleep(100000);
    }
}