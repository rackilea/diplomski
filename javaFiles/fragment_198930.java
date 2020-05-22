try {
    ZipInputStream zis = new ZipInputStream(url.openStream());
    ...
} catch (SSLHandshakeException sslEx) {
    logger.log(Level.ERROR, "SSL handshake failed.  Try installing the JCE Extension - see http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html");
}