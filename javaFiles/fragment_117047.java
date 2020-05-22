@Override
public void process(Exchange exchange) {
    try {
        // CXF service
        FnzPingServiceImpl fnzPingService = new FnzPingServiceImpl(url);
        fnzPingService.getPing();
    } catch (WebApplicationException e) {
        int responseCode = e.getResponse().getStatus();
        boolean isValidResponseCode = ResponseCodeUtil.isResponseCodeValid(responseCode);
        if (!isValidResponseCode) {
            // Sets a flag to stop for the StopStartProcessor
            stopRoute(exchange);
        }
    } 
}