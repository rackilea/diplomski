public void run() {
    Socket socket = socketQueue.take();
    try {
       // use the socket ...
    } finally {
       socketQueue.put(socket);
    }
}