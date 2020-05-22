function listenForFile(int port) {
    ServerSocket socket = new ServerSocket(serverPort);
        while (true) {

            Socket clientSocket = socket.accept();

            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            FileOutputStream fout = new FileOutputStream("/path/to/store/image.jpg");
            int i;
            while ( (i = dis.read()) > -1) {
                fout.write(i);
            }

            fout.flush();
            fout.close();
            dis.close();
            clientSocket.close();
        }
}