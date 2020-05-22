httpclient.getCredentialsProvider().setCredentials(
                    new AuthScope("localhost", 8080),
                    new UsernamePasswordCredentials("username", "password"));

HttpHost targetHost = new HttpHost("www.verisign.com", 443, "https");
HttpHost proxy = new HttpHost("localhost", 8080);

httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

HttpGet httpget = new HttpGet("/");