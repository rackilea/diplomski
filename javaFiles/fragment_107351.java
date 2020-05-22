try {

        int numOfConnectionLimit = 10; // or read number of connection from that config file

        ServerSocket listenerServ = new ServerSocket(servPort);
        System.out.println("Waiting...." + servPort + " "
                + "" + listenerServ.getInetAddress().getHostAddress());
        while (connectArray.size() < numOfConnectionLimit) {

            sock = listenerServ.accept();
            connectArray.add(sock);
            System.out.println("Client connected from: " + sock.getLocalAddress().getHostName());
            addUserName(sock);

            SocketChatServerReturn chat = new SocketChatServerReturn(sock);
            Thread X = new Thread(chat);
            X.start();

        }
    } catch (Exception exSock) {
        System.out.println("IOException on socket listen: " + exSock);
        exSock.printStackTrace();
    }
}