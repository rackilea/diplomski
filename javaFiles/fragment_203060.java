public class ResponseConsumer extends AsyncCharConsumer<String> {

    private int responseCode;
    private StringBuilder responseBuffer;
    private AsyncContext asyncCtx;

    public ResponseConsumer(AsyncContext asyncCtx) {
        this.responseBuffer = new StringBuilder();
        this.asyncCtx = asyncCtx;
    }

    @Override
    protected void releaseResources() { }

    @Override
    protected String buildResult(final HttpContext context) {
        try {
            PrintWriter responseWriter = asyncCtx.getResponse().getWriter();
            switch (responseCode) {
                case javax.servlet.http.HttpServletResponse.SC_OK:
                    responseWriter.print("success:" + responseBuffer.toString());
                    break;
                default:
                    responseWriter.print("error:" + responseBuffer.toString());
                }
        } catch (IOException e) { }
        asyncCtx.complete();        
        return responseBuffer.toString();
    }

    @Override
    protected void onCharReceived(CharBuffer buffer, IOControl ioc) throws IOException {
        while (buffer.hasRemaining())
            responseBuffer.append(buffer.get());
    }

    @Override
    protected void onResponseReceived(HttpResponse response) throws HttpException, IOException {        
        responseCode = response.getStatusLine().getStatusCode();
    }

}