public class RouteGenerator {

    private Set<RouteBuilder> routeBuilders = new HashSet<>();

    public String generateRoute(final int n) {

        routeBuilders.add(new RouteBuilder() {
            @Override public void configure() throws Exception {
                System.out.println("Building nested route!");
                System.out.println("Context: " + getContext());

                from("direct:myRoute." + n)
                    .transform() .simple("number: " + n)
                    .to("stream:out")
                    .process(new Processor() {
                        @Override
                        public void process(Exchange exchange) throws Exception {
                            Response response = new Response();
                            response.setStatus(Status.SUCCESS);
                            exchange.getOut().setBody(response);
                        }
                    });
            }
        });

        return "direct:myRoute." + n;

    }

    public Set<RouteBuilder> getRouteBuilders() {
        return routeBuilders;
    }

}