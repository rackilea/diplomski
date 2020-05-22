new Thread() {
    public void run() {
        ServerSocker serverSocket = new ServerSocket(12345);
        while (true) {
            Socket socket = serverSocket.accept();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream());
            pw.println("Histogram Info");
            // Print histogram info
            pw.flush();  pw.close();
            socket.close();
        }
    }
}