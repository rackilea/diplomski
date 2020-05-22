pool =new ThreadPoolExecutor(...) {
    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        // The future returns the Client object!
        client = (Client)((FutureTask)r).get();
        // Remove it from list of known clients
        clients.remove(client);

    }
};

while() {
    socket = serverSocket.accept();
    Client client = new Client(socket)

    // Submit to pool, using client as the future return value          
    pool.submit(client, client);
    // Add to list of known clients
    clients.add(client);
}

// When app is closing
private shutdown() {
    for(Client client : clients){
        client.shutdown();
    }
}