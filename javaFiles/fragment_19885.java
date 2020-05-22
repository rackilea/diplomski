Socket server = serverSocket.accept();

System.out.println("Just connected to " + server.getRemoteSocketAddress());

BufferedReader in = new  BufferedReader( new InputStreamReader(socket.getInputStream()));

System.out.println(in.readline());

PrintWriter out = new PrintWriter(server.getOutputStream());

out.println("Thank you for connecting to ");