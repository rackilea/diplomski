public void run() throws Exception {
    final ExecutorService ex = Executors.newSingleThreadExecutor();
    final HttpServer server = HttpServer.create(new InetSocketAddress(8888), 0);

    server.createContext("/test", (HttpExchange h) -> {
        // ... generate and write a response
        ex.submit(() -> { 
            server.stop(0); 
            System.out.println("HTTP server stopped"); 
        });
    });
    server.setExecutor(ex); 
    server.start();
    System.out.println("HTTP server started");
}