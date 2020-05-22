GcsOutputChannel outputChannel = gcsService.createOrReplace(fileName, options);
InputStream inputStream = item.getInputStream();

try {
    copy(inputStream, Channels.newOutputStream(outputChannel));
} finally {
    outputChannel.close();
    inputStream.close();
}

private void copy(InputStream input, OutputStream output) throws IOException {
    byte[] buffer = new byte[BUFFER_SIZE];
    int bytesRead = input.read(buffer);
    while (bytesRead != -1) {
        output.write(buffer, 0, bytesRead);
        bytesRead = input.read(buffer);
    }
}