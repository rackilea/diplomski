HttpServer server = HttpServer.create(new InetSocketAddress(1234), 0);

server.createContext("/favicon.ico", t -> {
  byte[] bytes = Files.readAllBytes(Paths.get("/path/to/favicon"));
  t.sendResponseHeaders(200, bytes.length);
  try (OutputStream os = t.getResponseBody()) {
    os.write(bytes);
  }
});

server.createContext("/", t -> {
  Charset charset = StandardCharsets.UTF_8;
  List<String> lines = Files.readAllLines(Paths.get("/path/to/index"), charset);

  t.sendResponseHeaders(200, 0);

  try (OutputStream os = t.getResponseBody()) {
    for (String line : lines) {
      os.write((line + "\n").getBytes(charset));
    }
  }
});

server.start();