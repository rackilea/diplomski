public class ServerActivator implements BundleActivator {
    public void start(BundleContext bundleContext) throws Exception {
        this.context.addFrameworkListener(new FrameworkListener() {
            public void frameworkEvent(FrameworkEvent event) {
                if (event.getType() == FrameworkEvent.STARTED) {
                    Component component = new Component();
                    Server server = new Server(Protocol.HTTP, 8080);
                    server.setName("Sample Server");
                    server.setNext(new SampleApplication());
                    component.getServers().add(server);
                    component.start();
                }
            }
        });
    }
}