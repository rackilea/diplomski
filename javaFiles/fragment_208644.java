// Do not do this in production!!!
HttpsURLConnection.setDefaultHostnameVerifier( new HostnameVerifier(){
    public boolean verify(String string,SSLSession ssls) {
        return true;
    }
});