Toolkit.getDefaultToolkit().addAWTEventListener(
    this::handleEvent,
    AWTEvent.KEY_EVENT_MASK | AWTEvent.ACTION_EVENT_MASK // The kind of events you want
);
/*...*/
private void handleEvent(AWTEvent awtEvent) {
    if (eventIsInteresting(awtEvent)) { // Do your own filtering
        logEvent(awtEvent); // Collect, send message, whatever
    }
}