System.setProperty("javax.net.ssl.trustStore", "path");
System.setProperty("javax.net.ssl.keyStore", "password");
System.setProperty("javax.net.ssl.keyStorePassword", "password");
System.setProperty("javax.net.ssl.keyStoreType", "JKS");
//done to prevent CN verification in client keystore
HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
   @Override
   public boolean verify(String hostname, SSLSession session) {
     return true;
   }
});