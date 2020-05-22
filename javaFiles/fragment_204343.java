private void getRequest() throws Exception {
    CloseableHttpClient httpclient = HttpClients.createDefault();

    CredentialsProvider credsProvider = new BasicCredentialsProvider();
    credsProvider.setCredentials(AuthScope.ANY,
            new NTCredentials("user", "password", "workstation", "domain"));

    HttpHost target = new HttpHost("tfs.web.com", 8080, "http");

    HttpClientContext context = HttpClientContext.create();
    context.setCredentialsProvider(credsProvider);

    HttpGet httpget = new HttpGet("/tfs/CollectionName/ProjectName/_apis/git/repositories/repo-name");
    CloseableHttpResponse response1 = httpclient.execute(target, httpget, context);
    try {
        HttpEntity entity1 = response1.getEntity();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    } finally {
        response1.close();
    }
}