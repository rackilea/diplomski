public void onApplicationEvent(ApplicationEvent event) {
    //...
    else if (event instanceof SessionConnectedEvent) {
        Principal user = subProtocolEvent.getUser();
        if (user == null) {
            return;
        }
    //...