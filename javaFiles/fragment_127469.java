public class SocketAccept{
    private ServerSocket mainSocket;
    private Socket clientSocket;

    private final AtomicReference<PrintWriter> printWriterHolder = new AtomicReference(null);

    public SocketAccept (int portNumber) {
        Singleton s = Singleton.getInstance();
        do {
        try {
            mainSocket = new ServerSocket(portNumber);
            clientSocket = mainSocket.accept();
            printWriterHolder.set(new PrintWriter(clientSocket.getOutputStream(), true));
            Thread clientThread = new ClientThread (clientSocket, printWriterHolder);
            clientThread.start();
        } catch (IOException ex) {
            Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        }while (true);//need to change this into thread pool or connection pool    
    } 
}