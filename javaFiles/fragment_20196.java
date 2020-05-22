class MyHandler implements ApplicationListener<ApplicationContextEvent> {

    public void onApplicationEvent(ApplicationContextEvent event) {
        if (event instanceof ContextStartedEvent) {
            onContextStarted((ContextStartedEvent)event);
        }
        ...
    }

    private void onContextStarted(ContextStartedEvent event) {
        ...
    }
}