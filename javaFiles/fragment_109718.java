Document doc;

final Socket connection = new Socket("192.168.142.55", 80);

try (final OutputStream out = connection.getOutputStream();
     InputStream in = connection.getInputStream()) {

    Callable<Void> requestSender = new Callable<Void>() {
        @Override
        public Void call()
        throws IOException {
            String request = "GET /state.xml HTTP/1.1\n\n";
            out.write(request.getBytes(StandardCharsets.US_ASCII));
            return null;
        }
    };
    ExecutorService background = Executors.newSingleThreadExecutor();
    Future<?> request = background.submit(requestSender);

    doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);

    request.get();
    background.shutdown();
}