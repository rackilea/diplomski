function sendFile (String serverIp, int serverPort) {
    int i;
    FileInputStream fis = new FileInputStream ("/path/to/your/image.jpg");

    Socket sock = new Socket(serverIp, serverPort);
    DataOutputStream os = new DataOutputStream(sock.getOutputStream());
    while ((i = fis.read()) > -1)
        os.write(i);

    fis.close();
    os.close();
    sock.close();
}