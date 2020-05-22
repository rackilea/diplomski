public class MainRouteBuilder extends RouteBuilder {

    public static CamelContext camelContext;

    public static RouteGenerator routeGenerator = new RouteGenerator();

    @Override
    public void configure() throws Exception {
        System.out.println("Building main route!");
        System.out.println("Context: " + getContext());

        camelContext = getContext();

        from("direct:mainRoute")
            .to(routeGenerator.generateRoute(2));


        for (RouteBuilder routeBuilder : routeGenerator.getRouteBuilders()) {
            includeRoutes(routeBuilder);
        }
    }

}