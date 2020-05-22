byte[] data = message.getBytes(); // convert to bytes
try {
    DatagramPacket sendPacket =
       new DatagramPacket( data, data.length, InetAddress.getLocalHost(), 6666 );

    socket.send( sendPacket ); //<<<<<<<<<<<<<<<<<<< REQUIRED

}
catch( UnknownHostException ex ) {
   displayArea.append( ex + "\n" );
}