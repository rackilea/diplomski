public static void receiveFile() throws Exception {
        //create a ServerSocket to listen for incoming connections
        ServerSocket server = new ServerSocket(1337);
        Socket senderSocket = server.accept();
        DataInputStream in = new DataInputStream(senderSocket.getInputStream());
        //first read the length of the file
        int lengthOfFile = in.readInt();
        byte[] buffer = new byte[lengthOfFile];

        //then read the actual file bytes
        in.readFully(buffer);

        FileOutputStream fos = new FileOutputStream("pathname");
        fos.write(buffer);
        fos.close();
    }