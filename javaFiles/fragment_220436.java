public void transfer(final File f, final String host, final int port) throws IOException {
    final Socket socket = new Socket(host, port);
    final BufferedOutputStream outStream = new BufferedOutputStream(socket.getOutputStream());
    final BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(f));
    final byte[] buffer = new byte[4096];
    for (int read = inStream.read(buffer); read >= 0; read = inStream.read(buffer))
        outStream.write(buffer, 0, read);
    inStream.close();
    outStream.close();
}