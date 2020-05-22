public static void sendFileToServer() throws Exception {
        Path path = Paths.get("path/to/file");
        byte[] data = Files.readAllBytes(path);

        // port has to be the same on client and server side
        int port = 1337; 

        //create a socket connection to the server
        Socket socket = new Socket("ipAdressOfTheServer", port);
        OutputStream out = socket.getOutputStream();

        // first write the length of the file so the receiver knows how much it has to read
        out.write(ByteBuffer.allocate(4).putInt(data.length).array());
        //write the actual file data
        out.write(data, 0, data.length);
        socket.close();
    }