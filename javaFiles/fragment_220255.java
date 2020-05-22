class TestingSession extends Thread {
   private static final Logger logger = Logger.getLogger(Class.class.getName());

   private Socket socket;

   TestingSession( Socket socket ) {
         this.socket = socket;
   }

   @Override
   public void run() {
      try {
         DataInputStream dataInputStream = new DataInputStream( socket.getInputStream() );
         while( !socket.isClosed() ) {
            System.out.println( dataInputStream.readUTF() );
         }

      } catch( Exception e ) {
      }

   }

}