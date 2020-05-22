private static void printDataSourceByteCount(DataSource source) throws IOException {
    try (InputStream is = source.getInputStream()) {

        long totalBytesRead = 0;
        byte [] buffer = new byte[2048];
        int bytesRead = is.read(buffer);
        while(bytesRead > 0) {
            totalBytesRead += bytesRead;
            bytesRead = is.read(buffer);
        }
        System.out.println(String.format("Read %d bytes", totalBytesRead));
    }
}