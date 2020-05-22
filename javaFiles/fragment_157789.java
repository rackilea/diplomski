class ConnectionReader implements TimerTask {

    InputStream inStream;
    byte[] buf;

    public ConnectionReader(Socket socket, int length){
        if (null == socket)
            throw new ConnectionException();
        if (inStream == null) {
            inStream = this.socket.getInputStream();
        }
        buf = new byte[length]
    }

    @Override
    public void run() {
        try {
            System.out.println("polling...");
            readData();
        } catch (InterruptedException e) {
            System.out.println("interrupted...");
            cancel()
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void readData() {
       try {
            receiveLength = inStream.read(buff, 0, length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}