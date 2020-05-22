ResteasyClient client = new ResteasyClientBuilder().defaultProxy(myProxy, myProxyPort).build(); 
Credentials credentials = new UsernamePasswordCredentials(me, mypassword);
ApacheHttpClient4Engine engine = (ApacheHttpClient4Engine)client.httpEngine();
HttpContext context =  new BasicHttpContext();
engine.setHttpContext(context);

CredentialsProvider provider = new BasicCredentialsProvider(); 
context.setAttribute(ClientContext.CREDS_PROVIDER, provider);
AuthScope authScope = new AuthScope(
            myProxy,
            myProxyPort,
            null,
            null);
System.out.println(client.target("https://www.google.com").request().get().readEntity(String.class));