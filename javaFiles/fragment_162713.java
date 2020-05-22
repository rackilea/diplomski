ServerSocket server = new ServerSocket(PORT);
try {
    while (true) {
        System.out.println("Waiting for client...");
        // open client socket to accept connection
        Socket client = server.accept();
        System.out.println(client.getInetAddress()+" contacted ");
        System.out.println("Creating thread to serve request");
        ServerStudentThread student = new ServerStudentThread(client);
        student.start();
    }
} finally {
    server.close();
}