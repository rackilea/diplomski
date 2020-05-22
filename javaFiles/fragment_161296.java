class MyEventHandler implements EventHandler {
    public void handleEvent(final Event event) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // here you can make the UI changes in response to the event data
            }
        });
    }
}