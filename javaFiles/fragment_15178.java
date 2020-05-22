public static void main(String[] args) throws Exception {
    HttpProcessor httpproc = HttpProcessorBuilder.create()
        .add(new RequestContent())
        .add(new RequestTargetHost())
        .add(new RequestConnControl())
        .add(new RequestUserAgent("Test/1.1"))
        .add(new RequestExpectContinue(true)).build();

    HttpRequestExecutor httpexecutor = new HttpRequestExecutor();

    HttpCoreContext coreContext = HttpCoreContext.create();
    HttpHost host = new HttpHost("localhost", 8080);
    coreContext.setTargetHost(host);

    DefaultBHttpClientConnection conn = new DefaultBHttpClientConnection(8 * 1024);
    ConnectionReuseStrategy connStrategy = DefaultConnectionReuseStrategy.INSTANCE;

    try {

        String[] targets = {
                "/",
                "/servlets-examples/servlet/RequestInfoExample",
                "/somewhere%20in%20pampa"};

        for (int i = 0; i < targets.length; i++) {
            if (!conn.isOpen()) {
                Socket socket = new Socket(host.getHostName(), host.getPort());
                conn.bind(socket);
            }
            BasicHttpRequest request = new BasicHttpRequest("GET", targets[i]);
            System.out.println(">> Request URI: " + request.getRequestLine().getUri());

            httpexecutor.preProcess(request, httpproc, coreContext);
            HttpResponse response = httpexecutor.execute(request, conn, coreContext);
            httpexecutor.postProcess(response, httpproc, coreContext);

            System.out.println("<< Response: " + response.getStatusLine());
            System.out.println(EntityUtils.toString(response.getEntity()));
            System.out.println("==============");
            if (!connStrategy.keepAlive(response, coreContext)) {
                conn.close();
            } else {
                System.out.println("Connection kept alive...");
            }
        }
    } finally {
        conn.close();
    }