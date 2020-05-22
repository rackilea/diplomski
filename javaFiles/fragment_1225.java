CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    CloseableHttpAsyncClient httpclient = HttpAsyncClients.custom()
            .setDefaultCredentialsProvider(credentialsProvider)
            .build();
    httpclient.start();
    try {
        HttpGet request = new HttpGet("http://www.apache.org/");
        Future<HttpResponse> future = httpclient.execute(request, null);
        HttpResponse response = future.get();
        System.out.println("Response: " + response.getStatusLine());
        System.out.println("Shutting down");
    } finally {
        httpclient.close();
    }
    System.out.println("Done");