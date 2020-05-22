Socket b;
ServerSocket ss;
ClientConnection newClient;
Thread newThread;

while(true) {
    try {
        b = ss.accept();

        System.out.println("Player from " + (b.getLocalAddress().toString().substring(1) + ":" + b.getLocalPort() + " has joined."));
        newClient = new ClientConnection(b);

        newThread = new Thread(newClient);
        newThread.start();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

class ClientConnection implements Runnable {

    //each connection should have its own socket and streams
    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    public ClientConnection(Socket socket) {
       this.socket = socket;
       this.outputStream = new ObjectOutputStream(socket.getOutputStream());
       this.inputStream = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        //do stuff with connection you have
    }
}