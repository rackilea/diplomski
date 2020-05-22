SSLContext sslcontext = SSLContexts.createDefault();        
SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
            sslcontext, SSLConnectionSocketFactory.STRICT_HOSTNAME_VERIFIER);

CloseableHttpClient httpClient = HttpClients.custom()
        .setSSLSocketFactory(sslsf)
        .build();    
HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext.getSocketFactory());