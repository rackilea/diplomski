public class webServiceClient{

    HttpClientPool httpClientPool;

    private static final Logger logger = Logger.getLogger(HttpClientPool.class);

    public sendSOAPMessage(String url, String soapAction, String userToken){
        HttpPost post = new HttpPost(url);
        HttpEntity entity = new ByteArrayEntity(xml.getBytes("UTF-8"));

        post.setEntity(entity);
        post.setHeader("Content-type", "application/soap+xml; charset=UTF-8");
        post.setHeader("SOAPAction", soapAction);
        post.setHeader("Connection", "Keep-Alive");
        post.setHeader("Keep-Alive", "header");

        HttpClientContext clientContext = HttpClientContext.create();
        clientContext.setUserToken(userToken);
        try (CloseableHttpResponse response = httpClientPool.getHttpClient().execute(post, clientContext)) {
            String result = EntityUtils.toString(response.getEntity());
            logger.info("Response: " + result);

            EntityUtils.consume(response.getEntity());
        }
    }
}