public static void main(String[] args) throws Exception {
    LocalTestServer server = new LocalTestServer(null, null);

    try {
        server.start();      

        server.register("/*", new LoggingHandler());
        server.awaitTermination(3600 * 1000);

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        server.stop();
    }

}