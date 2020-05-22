class FuzzyReaderHelper {

   public static final long MAGIC_NUMBER = 1234567890L;

   public static DataInputStream getStream( File source ) {
      boolean magicNumberFound = false;
      for( int offset = 0; !magicNumberFound && offset < 8; ++offset ) {
         dis = new DataInputStream( new FileInputStream( source ));
         for( int i = 0; i < offset; ++i ) {
            dis.read();
         }
         try {
            long l;
            while(( l = dis.readLong()) != MAGIC_NUMBER ) {
               /* Nothing to do... */
            }
            magicNumberFound = true;
            for( int i = 0; i < 11; ++i ) {
               dis.read();
            }
            return dis;
         }
         catch( EOFException eof ){}
         dis.close();
      }
   // choose:
      throw new IllegalStateException( "Incompatible file: " + source );
   // or
      return null; 
   }
}