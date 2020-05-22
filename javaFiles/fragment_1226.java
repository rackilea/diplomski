CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
    httpclient.start();
    try {
        HttpGet request = new HttpGet("http://www.apache.org/");
        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credentialsProvider);
        Future<HttpResponse> future = httpclient.execute(request, context, null);
        HttpResponse response = future.get();
        System.out.println("Response: " + response.getStatusLine());
        System.out.println("Shutting down");
    } finally {
        httpclient.close();
    }
    System.out.println("Done");