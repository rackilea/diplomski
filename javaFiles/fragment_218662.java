private static String sendMessage(int command,String data,int port,String ip){
     try{
         String sendString=Integer.toString(command)+":"+data+'$'+'\n';
         BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));

         // Socket clientSocket = new Socket(ip, port);
         // clientSocket.setSoTimeout(30000);

         Socket clientSocket = new Socket();
         InetAddress addr = InetAddress.getByName(ip);
         SocketAddress sockaddr = new InetSocketAddress(addr, port);
         clientSocket.connect(sockaddr, 20000); // 20 seconds time out

         DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
         BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         outToServer.writeBytes(sendString);
         String rcvString = inFromServer.readLine();
         System.out.println("FROM DEVICE: " + rcvString);
         clientSocket.close();
         return rcvString;
     }catch(Exception e){
         System.err.println(e.getMessage());
     }

     return NULL;
 }