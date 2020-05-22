public static void main(String[] args) throws IOException {
    Scanner kb = new Scanner(System.in);

    System.out.print("Enter IP Address: ");
    final String ip = kb.nextLine();
    System.out.print("Enter Port: ");
    final int port = kb.nextInt();

    //open socket
    final Socket socket = new Socket(ip, port);

    //create reader/writer only once
    final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    final PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

    //new thread just to read from socket
    new Thread(){
        public void run() {
            String line;
            try {
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }

                //remote has closed socket. quit
                System.exit(0); 
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }.start();

    //get keyboard input and send
    while (true) {
        String line = kb.nextLine();
        if (line.equalsIgnoreCase("exit"))
            System.exit(0); //user has typed in "exit". quit

        //send line to remote
        out.println(line);
    }

}