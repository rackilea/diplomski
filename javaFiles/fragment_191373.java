public class HttpClientMock extends HttpClient  {
    private String downloadUrl = "http://my.original.json.url";

    public HttpClientMock()  {
        super();
    }

    public HttpClientMock(String downloadUrl)  { 
        this.downloadUrl = downloadUrl;
    }

    @Override
    protected String getConnectionString()  {
        return downloadUrl;
    }
}