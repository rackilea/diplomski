public void initChannel(SocketChannel ch) throws Exception {
    SSLEngine sslEngine = SSLContext.getDefault().createSSLEngine();
    sslEngine.setUseClientMode(true);
    ch.pipeline()
      .addLast("ssl", new SslHandler(sslEngine));
}