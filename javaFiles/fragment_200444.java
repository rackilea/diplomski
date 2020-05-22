String bonjourServiceType = "_http._tcp.local.";
bonjourService = JmDNS.create();
bonjourService.addServiceListener(bonjourServiceType, bonjourServiceListener);
ServiceInfo[] serviceInfos = bonjourService.list(bonjourServiceType);
for (ServiceInfo info : serviceInfos) {
  System.out.println("## resolve service " + info.getName()  + " : " + info.getURL());
}
bonjourService.close();