class IRC
{
      //Connection Details
      String server = "IRC ADDRESS";
      String nick = "NICKNAME";
      String login = "LOGIN";
      String Pass = "PASS";  
      String channel = "CHANNLE";

  //Socket Stuff
  Socket socket;
  BufferedWriter writer;
  BufferedReader reader;


      public void HandleChat() throws Exception 
      {
           socket = new Socket(server, 6667);

           writer = new BufferedWriter(
               new OutputStreamWriter(socket.getOutputStream( )));

           reader = new BufferedReader(
               new InputStreamReader(socket.getInputStream( )));


           // Log on to the server.      
           writer.write("PASS " + Pass + "\r\n");
           writer.write("NICK " + nick + "\r\n");
           writer.write("USER " + login +"\r\n");
           writer.flush( );

           // Read lines from the server until it tells us we have connected.
           String line = null;

           while (((line = reader.readLine( )) != null))
           {
           }            
      }
}