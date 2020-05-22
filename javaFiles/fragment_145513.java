try {
        Socket socket = new Socket("127.0.0.1", port);  //Port dependent on your DB/Server
        // Server is up
        socket.close();
    }
    catch (IOException e)
    {
        // Server is down
    }