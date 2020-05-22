HttpHost targetHost = new HttpHost("app.test.com", 443, "https");
AuthCache authCache = new BasicAuthCache();
authCache.put(targetHost, new BasicScheme());

CredentialsProvider credsProvider = new BasicCredentialsProvider();
credsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("User", "Password"));

final HttpClientContext context = HttpClientContext.create();
context.setCredentialsProvider(credsProvider);
context.setAuthCache(authCache);

HttpClient client = HttpClientBuilder.create().build();
HttpResponse response = null;

response = client.execute(
            new HttpGet("https://app.test.com/testing/rest/authentication-point/authentication"),
            context);