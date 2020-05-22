int connectiontimeout = 1000; //1 second
int sockettimeout = 1000;

HttpParams httpparameters = new BasicHttpParams();

HttpConnectionParams.setConnectionTimeout(httpparameters, connectiontimeout);
HttpConnectionParams.setSoTimeout(httpparameters, sockettimeout);

HttpClient httpclient = new DefaultHttpClient(httpparameters);