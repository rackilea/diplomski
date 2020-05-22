public class StoreServer {

    static ArrayList<String[]> list2 = new ArrayList<String[]>();
    static List<Customer> customers = new LinkedList<Customer>();

    public static void main(String[] args) throws IOException {
        System.out.println("The server is running.");
        int clientNumber = 0;
        ServerSocket listener = new ServerSocket(3355);
        Thread commandListenerThread = new Thread(new CommandListener());
        commandListenerThread.start();
        try {
            while (true) {
                Socket socket = listener.accept();
                Customer cust = new Customer(socket, clientNumber++);
                customers.add(cust);
                new Thread(cust).start();
            }
        } finally {
            listener.close();
        }
    .....