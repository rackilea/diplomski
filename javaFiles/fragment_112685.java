...
FTPClient client = new FTPClient();
CertManager certMan = new CertManager("");
SSLSocketFactory sslSocketFactory = null;
try{
    sslSocketFactory = certMan.getSSLSocketFactory();
} catch (Exception e) {
    e.printStackTrace();
}
client.setSSLSocketFactory(sslSocketFactory);
client.setSecurity(FTPClient.SECURITY_FTPS); // or client.setSecurity(FTPClient.SECURITY_FTPES);
...