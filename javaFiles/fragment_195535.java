public static DefaultHttpClient getClient(String username, String password,
        Integer timeOut) {
    HttpParams httpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(httpParams, timeOut);
    HttpConnectionParams.setSoTimeout(httpParams, timeOut);
    DefaultHttpClient retHttpClient = new DefaultHttpClient(httpParams);
    if (username != null) {
        retHttpClient.getCredentialsProvider().setCredentials(
                new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
                new UsernamePasswordCredentials(username, password));
    }

    return retHttpClient;
}