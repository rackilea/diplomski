Socket s = new Socket(InetAddress.getByName("localhost"), STOP_PORT);
try {
    OutputStream out = s.getOutputStream();
    out.write((STOP_KEY + "\r\nstop\r\n").getBytes());
    out.flush();
} finally {
    s.close();
}