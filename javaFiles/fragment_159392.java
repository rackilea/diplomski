try (ServerSocket serverSocket = new ServerSocket(portNumber))
{
  while (running)
  {
    Socket clientSocket = serverSocket.accept();
    new Thread(new ClientHandler(clientSocket)).start();
  }
}