protected static void start(JFrame window) {
        ServerSocket server = null;
        try {
            server = new ServerSocket();
            SocketAddress addr = new InetSocketAddress(hostname, port);
            server.bind(addr);

            Socket socket = server.accept();

            window.setVisible(false);

            // Pass the socket to the thread to allow it to perform the work
            Thread thread = new Thread(new Incomming(socket));
            thread.start();

        } catch (IOException ex) {
            //...//
        }

    }

public class Incomming implements Runnable {

    private final Socket socket;

    public Incomming(Socket socket) {
        //?? What's this for, this is VERY wrong
        // UI Interaction should ONLY occur within the context of the EDT
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
        frame.pack();

        this.socket = socket;

    }

    public void run() {
        if (socket != null) {
            DataInputStream is = null;
            try {
                is = new DataInputStream(socket.getInputStream());
                while (!Thread.currentThread().isInterrupted()) {
                    int n = is.readInt();
                    if (n == -1) {
                        break;
                    }
                    byte[] b = new byte[n];
                    is.readFully(b);
                    //...//
                }
                System.out.println("Stream closed.");
            } catch (IOException e) {
            } finally {
                // Finally clean up...
                try {
                    is.close();
                } catch (Exception e) {
                }
                try {
                    socket.close();
                } catch (Exception e) {
                }
            }
        }
    }
}