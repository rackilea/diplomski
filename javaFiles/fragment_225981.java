authCache.put(host, basicAuth);
CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));
HttpClientContext _context = HttpClientContext.create();
_context.setAuthCache(authCache);
_context.setCredentialsProvider(credentialsProvider);
responseBody = httpclient.execute(_http, response, _context);