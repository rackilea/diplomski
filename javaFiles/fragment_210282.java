public static void main(String[] args) throws UnknownHostException,
        IOException {
    boolean open = true;
    Socket socket = SocketFactory.getDefault().createSocket();
    try {
        socket.setSoTimeout(5000);
        socket.connect(new InetSocketAddress("127.0.0.1", 25565));
        socket.close();
    } catch (ConnectException e) {
        open = false;
        System.err.println(e);
    }

    System.out.println(open);
}