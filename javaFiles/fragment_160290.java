public static void main(String... args) throws IOException {
    switch(args.length) {
        case 1: {
            // server
            ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]));
            Socket s = ss.accept();
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            // will deadlock before it gets here
            break;
        }
        case 2: {
            Socket s = new Socket(args[0], Integer.parseInt(args[1]));
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            // will deadlock before it gets here
            break;
        }
        default:
            System.err.println("Must provide either a port as server or hostname port as client");
    }
}