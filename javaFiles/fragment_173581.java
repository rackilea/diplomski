Component component = new Component();
component.setName("My component");

component.getServers().add(Protocol.HTTP, 8182);

MyApplication application = new MyApplication();
// To attach application on /www.example.com
component.getDefaultHost().attach("www.example.com", application);
// To attach application on /
component.getDefaultHost().attachDefault(application);

component.start();