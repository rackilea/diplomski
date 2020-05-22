try {
   create server socket and bind to port
   while server is online
      listen for incoming connections
      if the client connection is accepted [1]
         start client thread
catch exception
   handle exception
finally
   make sure the server socket is disconnected
   cleanup