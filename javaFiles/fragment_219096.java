try {
        ServerSocket serverSocket = new ServerSocket(8000);
        informationArea.appendText("Server started at " + new Date() + '\n');

        new Thread(() -> {
            int clientNumber = 1;
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    InetAddress inetAddress = socket.getInetAddress();

                    Platform.runLater(() -> 
                        informationArea.appendText(
                            "Client: " + clientNumber++
                            + "\n\thost name: " + inetAddress.getHostName()
                            + "\n\tIP address " + inetAddress.getHostAddress() + "\n\n"
                        )
                    );

                    ClientHandler task = new ClientHandler(socket);
                    new Thread(task).start();
                } catch (IOException ex) {
                    Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();

    } catch (IOException ex) {
        System.err.println(ex);
    }