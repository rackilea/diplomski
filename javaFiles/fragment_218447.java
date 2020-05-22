X509TrustManager manager = null;
FileInputStream fs = null;

TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

try
{
    fs = new FileInputStream(System.getProperty("javax.net.ssl.trustStore")); 
    keyStore.load(fs, null);
}
finally
{
    if (fs != null) { fs.close(); }
}

trustManagerFactory.init(keyStore);
TrustManager[] managers = trustManagerFactory.getTrustManagers();

for (TrustManager tm : managers)
{
    if (tm instanceof X509TrustManager) 
    {
        manager = (X509TrustManager) tm;
        break;
    }
}