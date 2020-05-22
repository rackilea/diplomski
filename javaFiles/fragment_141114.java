int iReadSize;
byte[] buffer = new byte[4096];

try (InputStream inputStream = connection.getInputStream();) {
    while ((iReadSize = inputStream.read(buffer)) != -1) {
        System.out.println(new String(buffer, 0, iReadSize));
    }
} catch (IOException error) {
}