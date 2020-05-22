HttpParams httpParams = new BasicHttpParams();
HttpConnectionParams.setConnectionTimeout(httpParams, 10000);

HttpConnectionParams.setSoTimeout(httpParams, 10000);

HttpClient client = new DefaultHttpClient(httpParams);