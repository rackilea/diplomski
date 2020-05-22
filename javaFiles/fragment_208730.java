set_time_limit( 0 );
// Set the ip and port we will listen on
$address = '127.0.0.1';
$port = 6789;

// Create a TCP Stream socket
$sock = socket_create( AF_INET, SOCK_STREAM, 0 ); // 0 for  SQL_TCP
// Bind the socket to an address/port
socket_bind( $sock, 0, $port ) or die( 'Could not bind to address' );  //0 for localhost
// Start listening for connections
socket_listen( $sock );

//loop and listen
while (true) {
  /* Accept incoming  requests and handle them as child processes */
  $client = socket_accept( $sock );
  // Read the input  from the client – 1024000 bytes
  $input = socket_read( $client, 1024000 );

  // from here you need to do your database stuff
  // and handle the response 

   // Display output  back to client
  socket_write( $client, $response );
  socket_close( $client );
}
// Close the master sockets
socket_close( $sock );