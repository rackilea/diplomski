ByteBuffer bb = new ByteBuffer.allocate( 1024 );

short version = 0x0001;
short request = 0x0011;
int size = 0x08;

bb.order( ByteOrder.LITTLE_ENDIAN );
bb.put( version );
bb.put( request );
bb.put( size );

socket.getChannel().write( bb );