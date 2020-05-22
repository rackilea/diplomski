class TestingSession extends Thread {
   private static final Logger logger = Logger.getLogger(Class.class.getName());

   private Socket socket;

   TestingSession( Socket socket ) {
      try {

         DataInputStream dataInputStream = new DataInputStream( socket.getInputStream() );
         this.socket = socket;

         while( !socket.isClosed() ) {
            System.out.println( dataInputStream.readUTF() );
         }

      } catch( Exception e ) {
      }
   }

}