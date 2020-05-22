private static final PoolingHttpClientConnectionManager CONNECTION_MANAGER = new PoolingHttpClientConnectionManager();

static
{
    CONNECTION_MANAGER.setDefaultMaxPerRoute(2);
    CONNECTION_MANAGER.setMaxTotal(4);
}

public static void main(String[] args)
{
    HttpGet httpget = new HttpGet("url");
    httpget.addHeader("X-Requested-With", "com.valvesoftware.android.steam.community");
    CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).setConnectionManager(CONNECTION_MANAGER).build();
    try (CloseableHttpResponse response = httpclient.execute(httpget, this.context))
    {
        HttpEntity entity = response.getEntity();

        try (InputStream instream = entity.getContent())
        {
            if (handle != null)
            {
                if (response.getStatusLine().getStatusCode() >= 400)
                {
                    handle.handleError(instream);
                }
                else
                {
                    handle.handle(instream);
                }
            }
        }
    }
    catch (HttpHostConnectException | InterruptedIOException | ClientProtocolException ignored)
    {

    }
}