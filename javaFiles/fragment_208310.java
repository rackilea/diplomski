Certificate[] certificates = null;
if(webSocket.hasSSLSupport()) {
    try {
        certificates = webSocket.getSSLSession().getPeerCertificates();
    } catch (SSLPeerUnverifiedException e) {
        logger.error("Could not read SSL Certificates");
        e.printStackTrace();
    }
}