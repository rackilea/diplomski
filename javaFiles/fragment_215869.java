private class MyWorkerListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
        case MyWorker.LISTEN_STATE:
            String listenState = evt.getNewValue().toString();
            // show in text field
            break;
        case MyWorker.CURRENT_PORT_ID:
            String currentPortId = evt.getNewValue().toString();
            // use this to decide which tab to change to
            break;
        case MyWorker.DATA_FEED:
            String dataFeed = evt.getNewValue().toString();
            // show where needed
            break;

        default:
            break;
        }
    }
}