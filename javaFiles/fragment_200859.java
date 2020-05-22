public void writeMsg(String msg) {
        try {
            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
            outToServer.writeBytes("From client: " + msg + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }