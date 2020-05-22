try (InputStream is = new FileInputStream("myfile.xls")) {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    int nRead;
    byte[] dataPart = new byte[16384];
    while ((nRead = is.read(dataPart, 0, dataPart.length)) != -1) {
      buffer.write(dataPart, 0, nRead);
    }
    buffer.flush();
    byte[] data = buffer.toByteArray();

    handle.sendRequest("https://server/API/file/id", "POST", "application/vnd.ms-excel", data);
}