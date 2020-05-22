public static void main(String[] args) throws IOException {
    // Replace with suitable executor
    ExecutorService executor = Executors.newCachedThreadPool();
    ServerSocket serverSocket = new ServerSocket(79);

    while (true) {
        final Socket socket = serverSocket.accept();
        executor.execute(new Runnable() {

            public void run() {
                try {
                    handleSocket(socket);
                } catch (IOException e) {
                    // Handle exception
                }

            }

            private void handleSocket(final Socket socket) throws IOException {
                // Do stuff with your socket, same as original code
            }
        });
    }
}