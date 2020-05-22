@Component
public class FileRouteBuilder extends RouteBuilder {
    public static final String DESTINATION = "file://out/";
    public static final String SOURCE = "file://in/?noop=true";

    @Override
    public void configure() throws Exception {
        from(SOURCE)
                .process(exchange -> {
                    //your processing here
                })
                .log("File: ${file:name} has been sent to: " + DESTINATION)
                .to(DESTINATION);
    }
}