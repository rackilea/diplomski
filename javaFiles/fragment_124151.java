NTCredentials userCredentials = new NTCredentials(userName, password,
                                  System.getProperty("COMPUTERNAME"), domain);
CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
credentialsProvider.setCredentials(new AuthScope(AuthScope.ANY_HOST,
                                       AuthScope.ANY_PORT), userCredentials);
HttpClientContext httpClientContext = HttpClientContext.create();
httpClientContext.setCredentialsProvider(credentialsProvider);
HttpClient httpClient = HttpClientBuilder.create().
                      setDefaultCredentialsProvider(credentialsProvider).build();