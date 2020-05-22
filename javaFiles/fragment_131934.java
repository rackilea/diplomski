Server server = new Server();
server.setIpaddress("192.168.0.4");
server.setServername("serverOne");
Service s1 = new Service();
s1.setServiceName("telnet");
s1.setServicePort(21); 
server.GetServices().add(s1); //Add like this.