Task<Socket> clientStartTask = new Task<Socket>() {
    @Override
    public Socket call() {
        return clientStart();
    }
});

clientStartTask.setOnSucceeded(e -> {
    Socket socket = clientStartTask.getValue();
    // do whatever you need with socket here...
});

Thread thread = new Thread(clientStartTask);
thread.setDaemon(true);
thread.start();