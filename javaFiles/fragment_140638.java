void SendFile(Socket sendingSocket, File fileToSend) {
    OutputStream stream = sendingSocket.getOutputStream();
    InputStream input = new FileInputStream(fileToSend);

    byte[] buffer = new byte[1024];
    int len;
    while(true) {
        len = input.read(buffer);
        if(len < 0) break;

        String header = "<DataPacket>" + len + "\n";
        stream.write(header.getBytes('ASCII'));
        stream.write(buffer, 0, len);
        String footer = "<DataPacket\>";
        stream.write(footer.getBytes('ASCII'));
    }

    input.close();
    stream.close();
}