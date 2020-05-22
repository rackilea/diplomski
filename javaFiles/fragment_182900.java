ServerSocket welcomeSocket = new ServerSocket(6789) 
  Socket connectionSocket = welcomeSocket.accept();
  BufferedReader inFromClient =
  new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
  DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
  clientmsg = inFromClient.readLine();
  System.out.println("Received: " + clientmsg);