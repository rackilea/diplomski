ByteBuffer buf = ByteBuffer.allocate( 9999 ); // capacity
 int nRead = fc.read( buf );
 InputStream is = new ByteArrayInputStream( buf.array() );
 DataInputStream dis = new DataInputStream( is );
 int version = dis.readInt(); //                   4 bytes
 long timestamp = dis.readLong();  //                 8 bytes
 int numUsers = dis.readInt(); //                   4 bytes