public void runServer() throws Exception {
    final ExecutorService ex = Executors.newSingleThreadExecutor();
    final CountDownLatch c = new CountDownLatch(1);

    HttpServer server = HttpServer.create(new InetSocketAddress(8888), 0);

    server.createContext("/test", (HttpExchange h) -> {
        StringBuilder resp = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++)
            resp.append(i).append(", ");
        String response = resp.toString();
        h.sendResponseHeaders(200, response.length());
        OutputStream os = h.getResponseBody();
        os.write(response.getBytes());
        os.close();
        c.countDown();           // count down, letting `c.await()` to return
    });

    server.setExecutor(ex);      // set up a custom executor for the server
    server.start();              // start the server
    System.out.println("HTTP server started");
    c.await();                   // wait until `c.countDown()` is invoked
    ex.shutdown();               // send shutdown command to executor
    // wait until all tasks complete (i. e. all responses are sent)
    ex.awaitTermination(1, TimeUnit.HOURS); 
    server.stop(0);
    System.out.println("HTTP server stopped");
}