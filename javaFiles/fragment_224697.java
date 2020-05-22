public void initService() {
    ConnectionStatusService service = new ConnectionStatusService();
    service.setBaseUrl(/* your URL */);
    service.setPeriod(Duration.seconds(1)); // run every 1 seconds
    service.lastValueProperty().addListener(/* your listener */); // or bind to this property

    // you may also want to add EventHandlers/Listeners to handle when the
    // service fails and such.
    service.start();
}