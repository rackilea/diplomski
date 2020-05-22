String message = URLEncoder.encode("my message", "UTF-8");

try {
    // instantiate the URL object with the target URL of the resource to
    // request
    URL url = new URL("http://www.example.com/comment");

    // instantiate the HttpURLConnection with the URL object - A new
    // connection is opened every time by calling the openConnection
    // method of the protocol handler for this URL.
    // 1. This is the point where the connection is opened.
    HttpURLConnection connection = (HttpURLConnection) url
            .openConnection();
    // set connection output to true
    connection.setDoOutput(true);
    // instead of a GET, we're going to send using method="POST"
    connection.setRequestMethod("POST");

    // instantiate OutputStreamWriter using the output stream, returned
    // from getOutputStream, that writes to this connection.
    // 2. This is the point where you'll know if the connection was
    // successfully established. If an I/O error occurs while creating
    // the output stream, you'll see an IOException.
    OutputStreamWriter writer = new OutputStreamWriter(
            connection.getOutputStream());

    // write data to the connection. This is data that you are sending
    // to the server
    // 3. No. Sending the data is conducted here. We established the
    // connection with getOutputStream
    writer.write("message=" + message);

    // Closes this output stream and releases any system resources
    // associated with this stream. At this point, we've sent all the
    // data. Only the outputStream is closed at this point, not the
    // actual connection
    writer.close();
    // if there is a response code AND that response code is 200 OK, do
    // stuff in the first if block
    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
        // OK

        // otherwise, if any other status code is returned, or no status
        // code is returned, do stuff in the else block
    } else {
        // Server returned HTTP error code.
    }
} catch (MalformedURLException e) {
    // ...
} catch (IOException e) {
    // ...
}