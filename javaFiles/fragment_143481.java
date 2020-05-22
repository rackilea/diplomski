ClientConfig config = new DefaultClientConfig();
config.getClasses().add(MyFileProvider.class);
URLConnectionClientHandler clientHandler = new URLConnectionClientHandler(new HttpURLConnectionFactory() {
     @Override
     public HttpURLConnection getHttpURLConnection(URL url) throws IOException {
           HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setChunkedStreamingMode(1024);
                return connection;
            }
});
Client client = new Client(clientHandler, config);