String newLine;
while ( true ) {
newLine = inFromClient.readLine();              
          if (newLine.equalsIgnoreCase("END"))
{
    break;
}

          newLine = newLine.toUpperCase();                 

// Send message             
          network.writeUTF(newLine);
}
// Close sockets.  This will cause the client to exit

sock.close();               
server.close();