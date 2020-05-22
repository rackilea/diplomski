void pipRemoteHttpResource(String url, String username, String password, int timeout, OutputStream out) {
    .. same code ..
    if (statusLine.getStatusCode() == 200)
        pipeStreams(response.getEntity().getContent(), out);
    .. same code ..
}


// writes input to output
public static void pipeStreams(java.io.InputStream source, java.io.OutputStream destination) throws IOException {

    // 16kb buffer
    byte [] buffer = new byte[16 * 1024];
    int read = 0;
    while((read=source.read(buffer)) != -1) {
        destination.write(buffer, 0, read);
    }
    destination.flush();
    destination.close();
    source.close();
}