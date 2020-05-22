DefaultHttpClient httpClient = new DefaultHttpClient();
HttpParams params = httpClient.getParams();
HttpConnectionParams.setConnectionTimeout(params, timeout);
HttpConnectionParams.setSoTimeout(params, timeout);
ClientExecutor executor = new ApacheHttpClient4Executor(httpClient);

ClientRequest cr = new ClientRequest("http://www.someserviceurl.com/", executor);