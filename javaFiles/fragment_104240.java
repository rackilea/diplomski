Component component = new Component();
component.getServers().add(Protocol.HTTP, 8182);

MyApplication app = new MyApplication();
component.getDefaultHost().attachDefault(app);
component.getInternalRouter().attachDefault(app);