String authority = "https://login.microsoftonline.com/{tenantId}";
String resourceUrl = "https://management.azure.com";
ExecutorService service = Executors.newFixedThreadPool(1);
AuthenticationContext context = new AuthenticationContext(authority, true, service);
    // Acquire Token
Future<AuthenticationResult> result = context.acquireToken(
            resourceUrl,
         new ClientCredential(APP_ID, APP_SECRET),
    null
    );
String token = result.get().getAccessToken();
HttpClient client = HttpClientBuilder.create().build();
HttpGet request = new HttpGet("https://management.azure.com/subscriptions?api-version=2016-06-01");
request.addHeader("Authorization",result.get().getAccessTokenType()+ " "+ result.get().getAccessToken());
HttpResponse response = client.execute(request);
HttpEntity entity = response.getEntity();
// Read the contents of an entity and return it as a String.
String content = EntityUtils.toString(entity);
System.out.println(content);