// Use Decorator pattern to capture the SSL socket from the default SSLSocketFactory.
class MySSLSocketFactory extends SSLSocketFactory {
   // Load NDK shared library.
   static {
      System.loadLibrary("my_native_helper");
   }

   // All overridden methods will be forwarded to the real SSLSocketFactory.
   // The only addition is that the SSLSocket returned by createSocket() is
   // cached.
   SSLSocketFactory realFactory_ = HttpsURLConnection.getDefaultSSLSocketFactory();
   SSLSocket s_;

   // This native method copies data from a native pointer into a ByteBuffer.
   native void readNative(long pointer, ByteBuffer dst);

   // Use the cached SSLSocket to access native OpenSSL session data.
   void getSessionInfo() throws NoSuchFieldException, IllegalAccessException {
      // Get the protected OpenSSL ssl_session_st pointer. Note that this
      // is not part of the API and could change across Android versions.
      // See https://android.googlesource.com/platform/external/conscrypt/+/lollipop-mr1-dev/src/main/java/org/conscrypt/OpenSSLSessionImpl.java
      SSLSession session = s_.getSession();
      Field field = session.getClass().getDeclaredField("sslSessionNativePointer");
      field.setAccessible(true);
      long sessionPointer = field.getLong(session);

      // Read as many bytes as we need from the native pointer.
      ByteBuffer byteBuffer = ByteBuffer.allocateDirect(104);
      byteBuffer.order(ByteOrder.nativeOrder());
      readNative(sessionPointer, byteBuffer);

      // Parse the OpenSSL ssl_session_st. Note that the layout of this structure
      // may change with OpenSSL versions and different compilers/platforms (e.g.
      // 32-bit vs. 64-bit).
      // See https://github.com/openssl/openssl/blob/OpenSSL_1_0_0-stable/ssl/ssl.h#L451
      IntBuffer intBuffer = byteBuffer.asIntBuffer();
      Log.i("MyConnection", String.format("SSL version %04x", intBuffer.get(0)));

      int master_key_length = intBuffer.get(4);
      String master_key = "";
      for (int i = 0; i < master_key_length; ++i)
         master_key += String.format("%02x", byteBuffer.get(20 + i));
      Log.i("MyConnection", String.format("Master key %s", master_key));

      int session_id_length = intBuffer.get(17);
      String session_id = "";
      for (int i = 0; i < session_id_length; ++i)
         session_id += String.format("%02x", byteBuffer.get(72 + i));
      Log.i("MyConnection", String.format("Session ID %s", session_id));
   }

   @Override
   public String[] getDefaultCipherSuites() {
      return realFactory_.getDefaultCipherSuites();
   }

   @Override
   public String[] getSupportedCipherSuites() {
      return realFactory_.getSupportedCipherSuites();
   }

   @Override
   public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
      s_ = (SSLSocket)realFactory_.createSocket(s, host, port, autoClose);
      return s_;
   }

   @Override
   public Socket createSocket(String host, int port) throws IOException {
      s_ =  (SSLSocket)realFactory_.createSocket(host, port);
      return s_;
   }

   @Override
   public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
      s_ = (SSLSocket)realFactory_.createSocket(host, port, localHost, localPort);
      return s_;
   }

   @Override
   public Socket createSocket(InetAddress host, int port) throws IOException {
      s_ =  (SSLSocket)realFactory_.createSocket(host, port);
      return s_;
   }

   @Override
   public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
      s_ = (SSLSocket)realFactory_.createSocket(address, port, localAddress, localPort);
      return s_;
   }
}