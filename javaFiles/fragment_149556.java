public static void receiveFile(String serverAddress, int port, String fileName, String fileOut) throws IOException {
    Socket client = new Socket(serverAddress, port);
    client.setSoTimeout(5000);
    PrintWriter out = new PrintWriter(client.getOutputStream(), true);
    DataInputStream dis = new DataInputStream(client.getInputStream());

    try {
        out.println("101|" + fileName + "\n");

        if (dis.readLine().equals("201")) {
            int br;
            byte[] data = new byte[4096];

            FileOutputStream fos = new FileOutputStream(fileOut);

            while ((br = dis.read(data, 0, data.length)) != -1){
                fos.write(data, 0, br);
            }

            fos.close();
            dis.close();
        }
    } catch (SocketTimeoutException ste) {
        ste.printStackTrace();
        client.close();
    }
}