public class LocalService {

    public LocalService() {
    }

    public static void main(String[] args) throws IOException  {
        HttpServer server =  HttpServer.create(new InetSocketAddress("localhost", 8888), 0);
        server.setExecutor(Executors.newSingleThreadExecutor());
        server.createContext("/", httpExchange -> {

            StringBuilder builder = new StringBuilder();

            int read;
            byte buffer[] = new byte[1024];

            InputStream is = httpExchange.getRequestBody();
            while ((read = is.read(buffer)) != -1) {
                builder.append(new String(buffer, 0, read));
            }

            is.close();

            String response = String.format("{\"request\": \"%s\"}", builder.toString());

            Headers headers = httpExchange.getResponseHeaders();
            headers.add("Content-Type", "application/json");
            headers.add("Access-Control-Allow-Origin", "*");
            httpExchange.sendResponseHeaders(200, response.length());

            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.flush();
            os.close();
        });

        server.start();
    }
}