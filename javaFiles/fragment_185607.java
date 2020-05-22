HostnameVerifier allHostsValid = new HostnameVerifier() {
    public boolean verify(String hostname, SSLSession session) {
        //...
    }
};

HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);