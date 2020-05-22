class Server {
    public static final int port = 11111;
    private final ServerSocket mServerSocket;
    private final Collection<Client> mClients;
    private boolean acceptNewClients;

    public Server() {
        mServerSocket = new ServerSocket(port);
        mClients = new ArrayList<Client>();
        acceptNewClients = true;

        ThreadManager.t.execute(new Runnable() {
            @Override
            public void run() {
                Client c;
                while (acceptNewClients) {
                    // On new client connected
                    c = new Client(mServerSocket.accept());
                    mClients.add(c);
                }
            }
        });
    }

    private void broadcast(String message) {
        for (Client c : mClients) 
            c.sendMessage(message);
    }
}

class ThreadManager {
    public static final ExecutorService t = Executors.newCachedThreadPool();   
}

final class Client implements Runnable {

    private Socket mSocket;
    private OutputStreamWriter mWriter;
    private InputStreamReader mReader;
    private boolean mContinueNetworking;
    private LinkedBlockingDeque<String> mCommandsToSend;

    public Client(Socket s) {
        mSocket = s;
        mWriter = new OutputStreamWriter(socket.getOutputStream());
        mReader = new InputStreamReader(socket.getInputStream());
        mCommandsToSend = new LinkedBlockingDeque<String>();

        mContinueNetworking = true;
        ThreadManager.t.execute(this);
    }

    public void sendMessage(String message) {
        mCommandsToSend.addLast(message);
    }

    @Override
    public void run() {
        String message;
        while (mContinueNetworking) {
            message = mCommandsToSend.take();
            try {
                mWriter.write(message);
                mWriter.write('\n');
                mWriter.flush();
            } catch (SocketException e) {
                e.printStackTrace();
                mContinueNetworking = false;
            } catch (IOException e) {
                e.printStackTrace();
                // optional: uncomment for retry in case of failure
//                 commandsToSend.put(toSend);
            }
        }
    }
}