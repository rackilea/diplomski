try {
    ServerSocket serverSocket = new ServerSocket(port);
    Socket socket = serverSocket.accept();
    File tempFile = new File(path, fileName);
    InputStream is = socket.getInputStream();
    BufferedInputStream bis = new BufferedInputStream(is);
    try (DataInputStream dis = new DataInputStream(bis)) {
        FileOutputStream fos = new FileOutputStream(tempFile);
        try (BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            bos.write(IOUtils.toByteArray(dis));
        }
    }
}
catch(Exception e) {
    e.printStackTrace();
}