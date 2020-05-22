protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    URLConnection connection = new URL("http://your.url.to.panda").openConnection();
    connection.setDoOutput(true); // POST.
    connection.setRequestProperty("Content-Type", request.getHeader("Content-Type")); // This one is important! You may want to check other request headers and copy it as well.

    // Set streaming mode, else HttpURLConnection will buffer everything.
    int contentLength = request.getContentLength();
    if (contentLength > -1) {
        // Content length is known beforehand, so no buffering will be taken place.
        ((HttpURLConnection) connection).setFixedLengthStreamingMode(contentLength);
     } else {
        // Content length is unknown, so send in 1KB chunks (which will also be the internal buffer size).
        ((HttpURLConnection) connection).setChunkedStreamingMode(1024);
    }

    InputStream input = request.getInputStream();
    OutputStream output = connection.getOutputStream();
    byte[] buffer = new byte[1024]; // Uses only 1KB of memory!

    for (int length = 0; (length = input.read(buffer)) > 0;) {
        output.write(buffer, 0, length);
        output.flush();
    }

    output.close();
    connection.getInputStream(); // Important! It's lazily executed.
}