class ProxyThread extends Thread {

    private final Socket clientSocket;

    public ProxyThread(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            // Read request
            InputStream incommingIS = clientSocket.getInputStream();
            byte[] b = new byte[8196];
            int len = incommingIS.read(b);

            if (len > 0) {
                System.out.println("REQUEST"
                        + System.getProperty("line.separator") + "-------");
                System.out.println(new String(b, 0, len));

                // Write request
                Socket socket = new Socket("localhost", 80);
                OutputStream outgoingOS = socket.getOutputStream();
                outgoingOS.write(b, 0, len);

                // Copy response
                OutputStream incommingOS = clientSocket.getOutputStream();
                InputStream outgoingIS = socket.getInputStream();
                for (int length; (length = outgoingIS.read(b)) != -1;) {
                    incommingOS.write(b, 0, length);
                }

                incommingOS.close();
                outgoingIS.close();
                outgoingOS.close();
                incommingIS.close();

                socket.close();
            } else {
                incommingIS.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}