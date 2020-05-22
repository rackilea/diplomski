public class CustomJSSEImplementation extends JSSEImplementation {
   @Override
   public ServerSocketFactory getServerSocketFactory(AbstractEndpoint endpoint) {
      return new CustomSslContextSocketFactory(endpoint);
   }

   @Override
   public SSLUtil getSSLUtil(AbstractEndpoint endpoint) {
      return new CustomSslContextSocketFactory(endpoint);
   }
}