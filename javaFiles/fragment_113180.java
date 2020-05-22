boolean flagDestinyStillDead = false;

//give the server 5 seconds to do whatever it needs to get back alive
try {
    Thread.sleep( 5000 );
}
catch ( InterruptedException ie ) {
    //ignore this. this probably won't happen unless you purposely cause it
}

//we now create a new connection, because the old connection died
socketToDestiny = new Socket();

//we try connecting to the server
try {
    socketToDestiny.connect(new InetSocketAddress(confs.destiny_ip,confs.destiny_port), 5000 );

    //if our connection was successful, we also need to create a new input and output stream
   streamToDestiny = new DataOutputStream( socketToDestiny.getOutputStream() );
   streamFromDestiny = new DataInputStream( socketToDesinty.getInputStream() );

    //we give the server 5 seconds to respond to any of our messages
    socketToDestiny.setSoTimeout( 5000 );

   //ask the server if its alive
   streamToDestiny.writeUTF( "Are you alive?" );

   //if the server responds, then by our definition of "alive", the server is alive
   String receivedMessage = streamToDestiny.readUTF();
   if ( receivedMessage.equals( "Yes, I am alive now!" ) ) {
        flagDestinyStillDead = false;
   }

   //if the server did not respond, then we would get a SocketTimeoutException
   //and we never would reach here

}
catch ( SocketTimeoutException e ) {

    //server had 5 seconds to accept our connection, and since the connection timed out
    //we presume that the server is still dead
    flagDestinyStillDead = true;
}
catch ( IOException e ) {

    //we gave the server 5 seconds already to get back alive using Thread.sleep(...)
    //if any of our communications fail, then the server must be dead.
    flagDestinyStillDead = true;
}