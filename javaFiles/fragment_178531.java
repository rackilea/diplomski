private ServiceListener mdnsServiceListener = new ServiceListener() {
  public void serviceAdded(ServiceEvent serviceEvent) {
    // Test service is discovered. requestServiceInfo() will trigger serviceResolved() callback.
    mdnsService.requestServiceInfo(Constants.mdnsServiceType, serviceEvent.getName());
  }

  public void serviceRemoved(ServiceEvent serviceEvent) {
    // Test service is disappeared.
  }

  public void serviceResolved(ServiceEvent serviceEvent) {
    // Test service info is resolved.
    String serviceUrl = serviceEvent.getInfo().getURL();
    // serviceURL is usually something like http://192.168.11.2:6666/my-service-name
};

mdnsService = JmDNS.create();
mdnsService.addServiceListener("my-service-type", mdnsServiceListener);
ServiceInfo[] infos = mdnsService.list(Constants.mdnsServiceType);

// Retrieve service info from either ServiceInfo[] returned here or listener callback method above.
mdnsService.removeServiceListener("my-service-type", mdnsServiceListener);
mdnsService.close();