DataInputStream dis = FuzzyReaderHelper.getStream( new File( root, "toto.dat" ));
if( dis != null ) {
   byte[] bytes = new byte[2];
   bytes[0] = dis.read();
   bytes[1] = dis.read();
   ...
}