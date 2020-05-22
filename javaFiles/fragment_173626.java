this.service_type = "_ros-master._tcp.local.";
this.service_name = "RosMaster";
this.service_port = 8888;
String service_key = "description"; // Max 9 chars
String service_text = "Hypothetical ros master";
HashMap<String, byte[]> properties = new HashMap<String, byte[]>();
properties.put(service_key, text.getBytes());
// service_info = ServiceInfo.create(service_type, service_name, service_port); // case 1, no text
// service_info = ServiceInfo.create(service_type, service_name, service_port, 0, 0, true, service_text); // case 2, textual description
service_info = ServiceInfo.create(service_type, service_name, service_port, 0, 0, true, properties); // case 3, properties assigned textual description
jmdns.registerService(service_info);

Case 1 and case 2 create services detectable by avahi, but they fail to resolve.
Case 3 works fine.