public class BasicHttpClientFactory implements HttpClientFactory {

    private String proxyHost;
    private Integer proxyPort;
    private boolean isSocksProxy = false;
    HttpClient httpClient;
    final Integer maxConnections = new Integer(10);
    private static final Log logger = LogFactory.getLog(BasicHttpClientFactory.class);

    @Override
    public HttpClient createNewClient() {

    SSLConnectionSocketFactory sslsf = null;
        try {
            SSLContextBuilder builder = SSLContexts.custom();

            builder.loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType)
                        throws CertificateException {
                    return true;
                }
            });

            SSLContext sslContext = builder.build();

            sslsf = new SSLConnectionSocketFactory(
                    sslContext, new X509HostnameVerifier() {
                        @Override
                        public void verify(String host, SSLSocket ssl)
                                throws IOException {
                        }

                        @Override
                        public void verify(String host, X509Certificate cert)
                                throws SSLException {
                        }

                        @Override
                        public void verify(String host, String[] cns,
                                String[] subjectAlts) throws SSLException {
                        }

                        @Override
                        public boolean verify(String s, SSLSession sslSession) {
                            return true;
                        }
                    });

        } catch (KeyManagementException e) {
        logger.error(e.getMessage(), e);
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(), e);
        } catch (KeyStoreException e) {
            logger.error(e.getMessage(), e);
        }


        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", new PlainConnectionSocketFactory())
                .register("https", sslsf)
                .build();

    PoolingHttpClientConnectionManager poolingConnManager = new PoolingHttpClientConnectionManager(registry);
    poolingConnManager.setMaxTotal(maxConnections);
    poolingConnManager.setDefaultMaxPerRoute(maxConnections);

    ConnectionKeepAliveStrategy keepAliveStrategy = new ConnectionKeepAliveStrategy() {
        @Override
        public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
            return 60 * 1000;
        }
    };

    if (proxyHost != null) {
        HttpHost proxy = new HttpHost(proxyHost, proxyPort);
        httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).setProxy(proxy).setConnectionManager(poolingConnManager).setKeepAliveStrategy(keepAliveStrategy).build();
    }else {
        httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).setConnectionManager(poolingConnManager).setKeepAliveStrategy(keepAliveStrategy).build();
    }
    return httpClient;
    }

    public void setProxyHost(String proxyHost) {
    this.proxyHost = proxyHost;
    }

    public void setProxyPort(Integer proxyPort) {
    this.proxyPort = proxyPort;
    }

    public void setSocksProxy(boolean isSocksProxy) {
    this.isSocksProxy = isSocksProxy;
    }
}