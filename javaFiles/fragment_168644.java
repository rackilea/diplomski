public class SocketManager {

    private Socket socket = null;
    private PrintWriter out = null;
    private BufferedReader in = null;

    private String ip;
    private int port;

    private Object socketLock = new Object();

    public SocketManager(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void connect() throws UnableToConnectException, AlreadyConnectedException {
        synchronized(socketLock) {
            if (socket == null || socket.isClosed()) {
                throw (new AlreadyConnectedException());
            }
            try {
                socket = new Socket(ip, port);
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                throw (new UnableToConnectException());
            }
            new Thread(new SocketThread()).start();
        }
    }

    public void disconnect() throws NotConnectedException {
        synchronized(socketLock) {
            if (isConnected()) {
                throw (new NotConnectedException());
            }
            try {
                socket.shutdownInput();
            } catch (IOException e) {}
            try {
                socket.shutdownOutput();
            } catch (IOException e) {}
            try {
                socket.close();
            } catch (IOException e) {}
        }
    }

    public boolean isConnected() {
        synchronized(socketLock) {
            return (socket != null && !socket.isClosed());
        }
    }

    private class SocketThread implements Runnable {

        @Override
        public void run() {
            String inputLine = null;
            try {
                while((inputLine = in.readLine()) != null) {
                    // do stuff (probably in another thread)
                }

                // it will get here if socket.shutdownInput() has been called (in disconnect)
                // or possibly when the server disconnects the clients


                // if it is here as a result of socket.shutdownInput() in disconnect()
                // then isConnected() will block until disconnect() finishes.
                // then isConnected() will return false and the thread will terminate.

                // if it ended up here because the server disconnected the client then
                // isConnected() won't block and return true meaning that disconnect()
                // will be called and the socket will be completely closed

                if (isConnected()) {
                    try {
                        disconnect();
                    } catch (NotConnectedException e) {}
                }
            } catch (IOException e) {
                // try and disconnect (if not already disconnected) and end thread
                if (isConnected()) {
                    try {
                        disconnect();
                    } catch (NotConnectedException e1) {}
                }
            }
        }

    }
}