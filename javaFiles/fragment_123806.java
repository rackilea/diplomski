int timeout = 25000;
try (Socket socket = new Socket()) {
    socket.connect(new InetSocketAddress("abc", 123), timeout);
    try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
         PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8")), true)) {

    }
}