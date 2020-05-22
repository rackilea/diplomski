//Receieve text file
        is = null;
        fos = null;
        bos = null;
        bufferSize = 0;
        String uid = createUid();

        try {
            clientSocket = echoServer.accept();
            clientSocket.setKeepAlive(true);
            clientSocket.setSoTimeout(10000);
            System.out.println("Client accepted from: " + clientSocket.getInetAddress());
        } catch (IOException ex) {
            System.out.println("Can't accept client connection. ");
        }

        try {
            is = clientSocket.getInputStream();
            bufferSize = clientSocket.getReceiveBufferSize();
            System.out.println("Buffer size: " + bufferSize);
        } catch (IOException ex) {
            System.out.println("Can't get socket input stream. ");
        }