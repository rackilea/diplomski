SSLContext ctx = SSLContext.getInstance("TLS");
ctx.init(new KeyManager[0], new TrustManager[] {new DefaultTrustManager()}, new SecureRandom());
SSLContext.setDefault(ctx);

URL url = new URL("https://www.trackobot.com/");
HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
con.setHostnameVerifier(new HostnameVerifier() {
    @Override
    public boolean verify(String arg0, SSLSession arg1) {
        return true;
    }
});
con.setRequestMethod("GET");
System.out.println("Response Code : " + con.getResponseCode());

BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
String line;
StringBuffer response = new StringBuffer();

while ((line = in.readLine()) != null) {
    response.append(line);
}
in.close();

System.out.println(response.toString());

private static class DefaultTrustManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

    @Override
    public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}