httpclient.getParams().setParameter(AuthPNames.PROXY_AUTH_PREF, AuthPolicy.BASIC);      
Credentials creds = new UsernamePasswordCredentials(proxyUsername, proxyPassword);

CredentialsProvider credsProvider = new BasicCredentialsProvider();
credsProvider.setCredentials(AuthScope.ANY, creds);
httpclient.getCredentialsProvider().setCredentials(AuthScope.ANY, credsProvider.getCredentials(AuthScope.ANY));