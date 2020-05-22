Socket s = null;
try {
    SocketAddress socketAddress = new InetSocketAddress(InetAddress.getByName(addr), 23);
    s = new Socket();
    s.connect(socketAddress, 1000);

    InputStream inputStream = s.getInputStream();
    OutputStream outputStream = s.getOutputStream();

    outputStream.write((login + "\n").getBytes());

    Thread.sleep(300);

    outputStream.write((password + "\n").getBytes());

    Thread.sleep(300);

    outputStream.write(("swupdate" + "\n").getBytes());
    Thread.sleep(300);

    // Open the file that is the first
    // command line parameter
    FileInputStream fstream = new FileInputStream(path_frm_vdsl);
    byte[] buffer = new byte[1024];
    int fillSize;

    // Read File chunk by chunk
    while ((fillSize = fstream.read(buffer)) != -1) {
        outputStream.write(buffer, 0, fillSize);
    }
    outputStream.close();
} finally {
    s.close();
}