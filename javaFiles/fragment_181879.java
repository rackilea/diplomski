public void initChannel(SocketChannel ch) throws Exception {
    SslContext sslContext = SslContextBuilder.forClient().build();
    ch.pipeline()
      .addLast(
          sslContext.newHandler(
              ch.alloc(), 
              host, 
              port
          )
      );
}