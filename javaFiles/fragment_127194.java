int TIMEOUT_MILLISEC = 30000;  
HttpParams httpParams = new BasicHttpParams();
HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT_MILLISEC);
HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
HttpClient httpclient = new DefaultHttpClient(httpParams);
HttpPost httppost = new HttpPost(url);
httppost.addHeader("Content-Type", "application/json");