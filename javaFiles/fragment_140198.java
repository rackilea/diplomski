BufferedInputStream input = new BufferedInputStream(request.getInputStream());
BufferedOutputStream output = new BufferedOutputStream(someOutputStream);
byte[] buffer = new byte[1024]; // 1KB buffer.

for (int length; (length = input.read(buffer)) > 0;) {
    processIfNecessary(buffer);
    output.write(buffer, 0, length);
}