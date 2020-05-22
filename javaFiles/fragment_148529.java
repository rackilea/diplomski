Map<Integer,Socket> clients=new HashMap<>();

 while (true) {
            java.util.Date today = Calendar.getInstance().getTime();
            System.out.println(today+" - Listening to new connections...");

           Socket clientSocket = m_ServerSocket.accept();
           clients.put(generateNewClientId(),clientSocket);
           ClientServiceThread cliThread = new ClientServiceThread( clientSocket);
           cliThread.start();
 }