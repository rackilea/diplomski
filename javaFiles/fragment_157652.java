public class CustomHttpComponentsConnection extends HttpComponentsConnection {

    private final HttpClient httpClient;

    private final HttpPost httpPost;

    private final HttpContext httpContext;

    private HttpResponse httpResponse;

    private ByteArrayOutputStream requestBuffer;

    protected CustomHttpComponentsConnection(HttpClient httpClient, HttpPost httpPost, HttpContext httpContext) {
        super(httpClient, httpPost, httpContext);

        Assert.notNull(httpClient, "httpClient must not be null");
        Assert.notNull(httpPost, "httpPost must not be null");
        this.httpClient = httpClient;
        this.httpPost = httpPost;
        this.httpContext = httpContext;
    }

    public HttpResponse getHttpResponse() {
    return httpResponse;
    }

    public HttpPost getHttpPost() {
        return httpPost;
    }

    @Override
    protected OutputStream getRequestOutputStream() throws IOException {
        return requestBuffer;
    }

    @Override
    protected void onSendBeforeWrite(WebServiceMessage message) throws IOException {
        requestBuffer = new ByteArrayOutputStream();
    }

    @Override
    protected void onSendAfterWrite(WebServiceMessage message) throws IOException {

        OutputStream out = getRequestOutputStream();

        String str = out.toString();

        str = str.replaceAll("<NFe>", "<NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\">");
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        bs.write(str.getBytes());

        getHttpPost().setEntity(new ByteArrayEntity(bs.toByteArray()));

        requestBuffer = null;
        if (httpContext != null) {
            httpResponse = httpClient.execute(httpPost, httpContext);
        }
        else {
            httpResponse = httpClient.execute(httpPost);
        }
    }

    @Override
    protected int getResponseCode() throws IOException {
        return httpResponse.getStatusLine().getStatusCode();
    }

    @Override
    protected String getResponseMessage() throws IOException {
        return httpResponse.getStatusLine().getReasonPhrase();
    }

    @Override
    protected long getResponseContentLength() throws IOException {
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            return entity.getContentLength();
        }
        return 0;
    }

    @Override
    protected InputStream getRawResponseInputStream() throws IOException {
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
             return entity.getContent();
        }
        throw new IllegalStateException("Response has no enclosing response entity, cannot create input stream");
    }

    @Override
    public Iterator<String> getResponseHeaderNames() throws IOException {
        Header[] headers = httpResponse.getAllHeaders();
        String[] names = new String[headers.length];
        for (int i = 0; i < headers.length; i++) {
            names[i] = headers[i].getName();
        }
        return Arrays.asList(names).iterator();
    }

    @Override
    public Iterator<String> getResponseHeaders(String name) throws IOException {
        Header[] headers = httpResponse.getHeaders(name);
        String[] values = new String[headers.length];
        for (int i = 0; i < headers.length; i++) {
            values[i] = headers[i].getValue();
        }
        return Arrays.asList(values).iterator();
    }