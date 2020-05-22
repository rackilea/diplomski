HttpClient client = new HttpClient();

HostConfiguration config = client.getHostConfiguration();
config.setProxy("someProxyURL", "someProxyPort");

Credentials credentials = new UsernamePasswordCredentials("username", "password");
AuthScope authScope = new AuthScope("someProxyURL", "someProxyPort");
client.getState().setProxyCredentials(authScope, credentials);

EntityEnclosingMethod method = new PostMethod(url);
method.setRequestEntity(new StringRequestEntity(requestXML, "text/xml", "utf-8"));