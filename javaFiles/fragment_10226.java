public class CookiesExample {

    public static void main(String[] args) throws Exception {
        //This object will store your cookies:
        BasicCookieStore cookieStore = new BasicCookieStore();

        //Create a client using our cookie store:
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build();

        try {
            //Execute request:
            HttpGet httpget = new HttpGet("https://example.com/");
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                //Consume the response:
                HttpEntity entity = response.getEntity();
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }

            //Whatever cookies that were sent by the server in that request 
            //are now stored in our cookie store. Subsequent requests will
            //send those cookies to the server.

            httpget = new HttpGet("https://example.com/my/awesome/internal/page");
            response = httpclient.execute(httpget);
            try {
                //Consume the response:
                HttpEntity entity = response.getEntity();
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}