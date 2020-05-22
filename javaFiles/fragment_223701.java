public class Network implements Runnable, Closeable {    
    private final Socket clientSocket;
    private final PrintWriter out;
    private final BufferedReader in;
    private volatile boolean closed = false;

    public Network(String hostname, int port) throws IOException {        
        clientSocket = new Socket(hostname, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void run() {
        try {
            for(String fromServer; (fromServer = in.readLine()) != null;) 
                System.out.println("Server: " + fromServer);
        } catch (IOException ex) {
            if (!closed)
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void send(String line) {
        out.println(line);
    }

    public void close() {
        closed = true;
        try { clientSocket.close(); } catch (IOException ignored) { }
    }
}