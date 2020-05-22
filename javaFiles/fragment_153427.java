class Server {
    private int maxConnections = 10;
    private ExecutorService executor = Executors.newFixedThreadPool(maxConnections);
    private User[] users = new User[maxConnections];

    //...

    while(running) {
        Socket socket = ss.accept();

        for(int i = 0; i < users.length; i++) {
            if(users[i] == null) {
                users[i] = new User(socket, i);
                executor.execute(users[i]);
                break;
            }
        }
    }

    //...

    public static void sendGlobalMessage(String message) throws IOException {
        for(User user : users)
            if(user != null)
                user.send(message);
    }

    public static void sendPrivateMessage(String message, int id) {
        User user = users[id];

        if(user != null) {
            user.send(message);
        }
    }
}

class User {
    private Socket socket;
    private int id;

    private DataOutputStream out;

    public User(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    public void send(String message) throws IOException {
        out.writeUTF(message);
        out.flush();
    }

    public void run() {
        DataInputStream in;
        //wrap in and out streams

        while(connected) {
            String data = in.readUTF();

            //Server.sendGlobalMessage(data);
            //Server.sendPrivateMessage(data, ...);
            sendMessage(data); //sends message back to client
        }
    }
}