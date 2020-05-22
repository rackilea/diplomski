final int TIMEOUT_MILLISEC = 5000;  // 5 seconds

HttpParams httpParams = new BasicHttpParams();
HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT_MILLISEC);
HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);

HttpClient httpClient = new DefaultHttpClient(httpParams);