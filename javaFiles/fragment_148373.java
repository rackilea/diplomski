public int send(byte[] str) throws IOException {
    InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
    socket = new Socket(serverAddr, SERVERPORT);
    out = socket.getOutputStream();
    out.write(str);
    out.flush();
    out.close();
    socket.close();
    return str.length;
}