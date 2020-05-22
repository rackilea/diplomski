private void readOutput(InputStream outputStream) throws IOException{
    byte[] buffer = new byte[100000];
    int bytesRead;
    while (outputStream.available() > 0) {
        bytesRead = outputStream.read(buffer);
        if (bytesRead > 0) {
            System.out.print(new String(buffer, 0, bytesRead));
        }
    }
}