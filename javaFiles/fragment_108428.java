public static void main(String[] args) throws Exception {
        new Thread(new BufferedReaderServer()).start();
        new Thread(new InputStreamServer()).start();
        final String requestString = "Line#1\nLine#2";

        System.out.println("\nSending to BufferedReaderServer");
        Socket clientSocket1 = new Socket(InetAddress.getLocalHost()
                .getHostAddress(), 8003);
        OutputStream outputStream1 = clientSocket1.getOutputStream();
        outputStream1.write(requestString.getBytes());
        Thread.sleep(6000);
        outputStream1.close();
        clientSocket1.close();

        Thread.sleep(1000);
        System.out.println("\nSending to InputStreamServer");

        Socket clientSocket2 = new Socket(InetAddress.getLocalHost()
                .getHostAddress(), 8004);
        OutputStream outputStream2 = clientSocket2.getOutputStream();
        outputStream2.write(requestString.getBytes());
        Thread.sleep(6000);
        outputStream2.close();
        clientSocket2.close();
    }

    static class BufferedReaderServer implements Runnable {

        public void run() {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(8003);
                Socket socket = serverSocket.accept();
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String s = null;
                System.out.println("BufferedReaderServer read START");
                while ((s = bufferedReader.readLine()) != null) {
                    System.out.println(s);
                }
                System.out.println("BufferedReaderServer read END");
                socket.getInputStream().close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    serverSocket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class InputStreamServer implements Runnable {

        public void run() {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(8004);
                Socket socket = serverSocket.accept();
                System.out.println("InputStreamServer read START");
                int ch;
                while ((ch = socket.getInputStream().read()) != -1) {
                    System.out.print((char) ch);
                }
                System.out.println("\nInputStreamServer read END");
                socket.getInputStream().close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    serverSocket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }