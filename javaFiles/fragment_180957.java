ExecutorService pool = Executors.newFixedThreadPool(mClientThreads);
try (ServerSocket server = new ServerSocket(mPort)) {
    while (mRunning) {
        final Socket client = server.accept();
        client.setSoTimeout(mTimeOut);
        pool.execute(() -> {
            mMessageHandler.handle(client); // mMessageHandler = NetworkMessageHandler
        });
    }
} catch (IOException ex) {
    System.out.println("IO Exception occurred in TCPServer: "
            + ex.getMessage());
} finally {
    System.out.println("Server stopped...");
}