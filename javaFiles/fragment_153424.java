public class Server {
    private ExecutorService executor = Executors.newFixedThreadPool(10);
    private Set<User> users = new HashSet<>();

    private boolean running;
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        running = true;

        Runnable acceptor = () -> {
            try(ServerSocket ss = new ServerSocket(port)) {
                while(running) {
                     User client = new User(ss.accept());
                     users.add(client);
                     executor.execute(client);
                }
            } catch(IOException e) {
                //if a server is already running on this port;
                //if the port is not open;
                e.printStackTrace();
            }
        };

        Runnable userInputReader = () -> {
            try(Scanner scanner = new Scanner(System.in)) {
                while(running) {
                    String input = scanner.nextLine();

                    for(User user : users) {
                        user.send(input);
                    }
                }
            } catch(IOException e) {
                //problem sending data;
                e.printStackTrace();
            }

        };

        Thread acceptorThread = new Thread(acceptor);
        Thread userThread = new Thread(userInputReader);
        acceptorThread.start();
        userThread.start();
    }

    public void stop() {
        running = false;
    }

    public static void main(String[] args) {
        new Server(15180).start();
        System.out.println("Server started!");
    }
}