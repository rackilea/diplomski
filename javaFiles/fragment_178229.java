public class EndpointControlBusFileRouteBuilder extends RouteBuilder {

    private static final Logger log = LoggerFactory.getLogger(EndpointControlBusFileRouteBuilder.class);

    private String routeId;
    private String ClusterId;

    public EndpointControlBusFileRouteBuilder(String routeId) {

        this.routeId = routeId;

    }

    @Override
    public void configure() throws Exception {

        log.info("*** JGroups routeCluster - RouteId : " + routeId + " ***");
        ClusterId = routeId + ".JGroups";

        from("jgroups:" + ClusterId + "?enableViewMessages=true&channelProperties=etc/jgroups.xml")
        .autoStartup(true)
        .routeId(ClusterId)
        .filter(dropNonCoordinatorViews())
        .threads().delay(delayIfContextNotStarted(SECONDS.toMillis(5))) // run in separated and delayed thread. Delay only if the context hasn't been started already. 
        .log("Starting JGroups JChannel Routes Consumer!!!!!!!!!!!!!!!!!!!!!")
        .to("controlbus:route?routeId=" + routeId + "&action=start&async=true");

    }

}

public class EndpointControlBusProcessor implements Processor {

    private String routeId = "";

    private static final Logger log = LoggerFactory.getLogger(EndpointControlBusProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {

        List<Route> routeList = exchange.getContext().getRoutes();
        ProducerTemplate template = exchange.getContext().createProducerTemplate();

        for ( Route rte : routeList ) {

            routeId = rte.getId();

//          log.info("ROUTES: " + routeId);
//          ServiceStatus routeStatus = exchange.getContext().getRouteStatus(routeId);
//          log.info("Route " + routeId + " Status: " + routeStatus);

            String status = template.requestBody("controlbus:route?routeId=" + routeId + "&action=status", null, String.class);
            log.info("Controlbus Route Status: " + status + " for route: " + routeId);

            if ( (null == status) || status.equalsIgnoreCase("Stopped") ) {

                exchange.getContext().addRoutes(new EndpointControlBusFileRouteBuilder(routeId));
//              status = template.requestBody("controlbus:route?routeId=" + routeId + "&action=status", null, String.class);
//              log.info("Controlbus Route Status: " + status + " for route: " + routeId);

            } else {

                log.info("Route " + routeId + " already started");

            }
        }
        template.stop();
    }
}