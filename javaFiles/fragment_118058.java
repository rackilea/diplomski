public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:C:/inputFolder?noop=true&recursive=true").to("file:C:/outputFolder");
    }
}