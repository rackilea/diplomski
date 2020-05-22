MY_LISTENER = new RemovalListener<Request, Connection>() {
    @Override
    public void onRemovaRequest RemovalNotification<Request, Connection> notification) {
        if (notification.wasEvicted()) {
            Connection c = notification.getValue();
            // send timeout response to client 
        }
    }
};