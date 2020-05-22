String getHttpResponseWithSSL(String url) throws Exception {
    //default truststore parameters
    System.setProperty("javax.net.ssl.trustStore", "/usr/lib/jvm/java-6-openjdk/jre/lib/securitycacerts");
    System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
    System.setProperty("javax.net.ssl.trustStoreType", "JKS");

    //my certificate and password
    System.setProperty("javax.net.ssl.keyStore", "mycert.pfx");
    System.setProperty("javax.net.ssl.keyStorePassword", "mypass");
    System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");


    HttpClient httpclient = new HttpClient();

    GetMethod method = new GetMethod();
    method.setPath(url);

    int statusCode = httpclient.executeMethod(method);
    System.out.println("Status: " + statusCode);

    method.releaseConnection();

    return method.getResponseBodyAsString();
}