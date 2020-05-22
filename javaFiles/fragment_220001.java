// put your multicast address here
InetAddress group = InetAddress.getByName( "244.10.10.10" );
MulticastSocket sock = new MulticastSocket( 5004 );
sock.joinGroup( group );

byte[] buf = new byte[1472];
DatagramPacket pack = new DatagramPacket( buf, buf.length );

while ( whatever ) {
    sock.receive( pack );
    // handle data
}

sock.leaveGroup( group );