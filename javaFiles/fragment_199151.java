public class Start implements HttpHandler{

    @Override
    public void handle(HttpExchange he) throws IOException {
        byte[] encoded = Files.readAllBytes(
                Paths.get("Views/start.html"));
        he.sendResponseHeaders(200, encoded.length);
        he.getResponseHeaders().set("Content-Type", "text/html");
        OutputStream os = he.getResponseBody();
        os.write(encoded);
        os.close();
    }

}