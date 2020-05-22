public class MyConnection implements Runnable {
   @Override
   public void run() {
      try {
         // Create the connection.
         URL url = new URL("https://www.google.com");
         HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();

         // Replace the default SSLSocketFactory with our own.
         MySSLSocketFactory sslSocketFactory = new MySSLSocketFactory();
         urlConnection.setSSLSocketFactory(sslSocketFactory);

         // Establish the TLS connection.
         int statusCode = urlConnection.getResponseCode();
         Log.i("MyConnection", String.format("status %d", statusCode));

         // Get SSL details from the captured socket.
         sslSocketFactory.getSessionInfo();

      } catch (IllegalAccessException e) {
         e.printStackTrace();
      } catch (NoSuchFieldException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();

      }
   }
}