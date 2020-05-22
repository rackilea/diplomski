public void run() {
   try {
   } catch( SomeException ex ) {
      logger.error( "Something bad happened", ex );
   } finally {
      out.close();   <<<< not a bad idea to try {} finally {} these statements too.
      in.close();    <<<< not a bad idea to try {} finally {} these statements too.
      socket.close();
   }
}