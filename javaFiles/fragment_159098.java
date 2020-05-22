Socket clientSocket = serverSocket.accept();
            ServerThread serverThread;
            if (portNumber == Server.SMTP_PORT_NUMBER) {
                serverThread = new SMTPThread(clientSocket, db);
                serverThread.setName("SMTP Thread " + ++threadCounter);
            } else {
                serverThread = new POP3Thread(clientSocket, db);
                serverThread.setName("POP3 Thread " + ++threadCounter);
            }
            serverThread.start();
            threadPool.put(serverThread);