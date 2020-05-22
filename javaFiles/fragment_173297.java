import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;

/**
 * This Socket factory will accept all certificates and all hostnames
 */
public class NonVerifyingSSLSocketFactory extends SocketFactory {
   private static SocketFactory nonVerifyingSSLSochetFactory;

   static {
      TrustManager [] distrustManager = new TrustManager [] {new X509ExtendedTrustManager () {
         @Override
         public void checkClientTrusted (X509Certificate [] chain, String authType, Socket socket) {

         }

         @Override
         public void checkServerTrusted (X509Certificate [] chain, String authType, Socket socket) {

         }

         @Override
         public void checkClientTrusted (X509Certificate [] chain, String authType, SSLEngine engine) {

         }

         @Override
         public void checkServerTrusted (X509Certificate [] chain, String authType, SSLEngine engine) {

         }

         public X509Certificate [] getAcceptedIssuers () {
            return null;
         }

         public void checkClientTrusted (X509Certificate [] c, String a) {
         }

         public void checkServerTrusted (X509Certificate [] c, String a) {
         }
      }};

      try {
         SSLContext sc = SSLContext.getInstance ("SSL");
         sc.init (null, distrustManager, new java.security.SecureRandom ());
         nonVerifyingSSLSochetFactory = sc.getSocketFactory ();
      } catch (GeneralSecurityException e) {
         throw new RuntimeException (e);
      }
   }

   /**
    * This method is needed. It is called by the LDAP Context to create the connection
    *
    * @see SocketFactory#getDefault()
    */
   @SuppressWarnings ("unused")
   public static SocketFactory getDefault () {
      return new NonVerifyingSSLSocketFactory ();
   }

   /**
    * @see SocketFactory#createSocket(String, int)
    */
   public Socket createSocket (String arg0, int arg1) throws IOException {
      return nonVerifyingSSLSochetFactory.createSocket (arg0, arg1);
   }

   /**
    * @see SocketFactory#createSocket(java.net.InetAddress, int)
    */
   public Socket createSocket (InetAddress arg0, int arg1) throws IOException {
      return nonVerifyingSSLSochetFactory.createSocket (arg0, arg1);
   }

   /**
    * @see SocketFactory#createSocket(String, int, InetAddress, int)
    */
   public Socket createSocket (String arg0, int arg1, InetAddress arg2, int arg3) throws IOException {
      return nonVerifyingSSLSochetFactory.createSocket (arg0, arg1, arg2, arg3);
   }

   /**
    * @see SocketFactory#createSocket(InetAddress, int, InetAddress, int)
    */
   public Socket createSocket (InetAddress arg0, int arg1, InetAddress arg2,
                               int arg3) throws IOException {
      return nonVerifyingSSLSochetFactory.createSocket (arg0, arg1, arg2, arg3);
   }

}