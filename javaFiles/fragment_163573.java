public boolean isServerUp(int port) {
        boolean isUp = false;
        try {
            Socket socket = new Socket("127.0.0.1", port);
//            Socket socket = new Socket("localhost", port); <- also this
            // Server is up
            isUp = true;
            socket.close();
        } catch (IOException e) {
            // Server is down
        }
        return isUp;
    }