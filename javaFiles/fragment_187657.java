class Server {

    public static void main(String[] args) {
        InputThread background = new InputThread(this).start();
        // Run your server here
    }
}

class InputThread {
    private final Server server;
    public InputThread(Server server) {
        this.server = server;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            // blocks for input, but won't block the server's thread
        }
    }
}