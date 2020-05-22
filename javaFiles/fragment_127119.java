try
{
  while (m_flagRunUserThreadManager)
  {
    try
    {
      m_listenSocket.setSoTimeout(10000);
      Socket clientSocket = m_listenSocket.accept();
      //create a thread for client
      MyClientHandler clientHandler = new ClientHandler(clientSocket);
      clientHandler.setPriority(Thread.MIN_PRIORITY);
      clientHandler.start(); 

    }
    catch(SocketTimeoutException excp)
    {
      String strError = "No requests for 10 Sec.";
      //display this message    
    }
  }
}
catch(IOException excp)
{
    // display the exception
}