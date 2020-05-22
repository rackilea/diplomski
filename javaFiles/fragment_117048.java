@Override
public void process(final Exchange exchange) {
    // routeBuilder is set on the constructor.
    final String routeId = routeBuilder.getClass().getSimpleName();
    Boolean stopRoute = ExchangeHeaderUtil.getHeader(exchange, Exchange.ROUTE_STOP, Boolean.class);
    boolean stopRoutePrim = BooleanUtils.isTrue(stopRoute);
    if (stopRoutePrim) {
        StopRouteThread stopRouteThread = new StopRouteThread(exchange, routeId);
        executorService.execute(stopRouteThread);
    } else {
        CamelContext context = exchange.getContext();
        Route route = context.getRoute(routeId);
        if (route == null) {
            try {
                context.addRoutes(routeBuilder);
            } catch (Exception e) {
                String msg = "Unable to add a route: " + routeBuilder;
                LOGGER.warn(msg, e);
            }
        }
    }
}