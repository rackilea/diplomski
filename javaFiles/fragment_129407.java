public class App {
    public static int retryCounter = 0; 
    public static void main(String[] args) {

        int maxAttempts = 4;
        HttpClient client = HttpClients.createDefault();
        HttpRequest request = new HttpGet("https://jsonplaceholder.typicode.com/todos/1");
        HttpResponse response;
        try {

            RetryConfig retryConfig = RetryConfig.<HttpResponse>custom().waitDuration(Duration.ofSeconds(1))
                    .maxAttempts(maxAttempts).retryOnResult(s -> {
                        try {
                            if (s.getStatusLine().getStatusCode() == 200) {

                                if (retryCounter < maxAttempts -1) {
                                    s.getEntity().getContent().close();
                                }
                                return true;
                            } else {
                                return false;
                            }
                        } catch (UnsupportedOperationException e1) {
                            return true;
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            return true;
                        }

                    }).build();
            RetryRegistry registry = RetryRegistry.of(retryConfig);
            Retry retry = registry.retry("Http client");
            retry.getEventPublisher().onRetry(e -> {
                retryCounter ++;
                System.out.println("Retrying" + e.getNumberOfRetryAttempts());

            });

            CheckedFunction0<HttpResponse> retryableSupplier = Retry.decorateCheckedSupplier(retry, () -> {

                HttpResponse res = client.execute((HttpUriRequest) request);
                return res;
            });
            response = (CloseableHttpResponse) Try.of(retryableSupplier).get();
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity));
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block`enter code here`
            e.printStackTrace();
        }
    }