public static String doPostSync(final String urlToRead, final String content) throws IOException {
    final String charset = "UTF-8";
    // Create the connection
    HttpURLConnection connection = (HttpURLConnection) new URL(urlToRead).openConnection();
    // setDoOutput(true) implicitly set's the request type to POST
    connection.setDoOutput(true);
    connection.setRequestProperty("Accept-Charset", charset);
    connection.setRequestProperty("Content-type", "application/json");

    // Write to the connection
    OutputStream output = connection.getOutputStream();
    output.write(content.getBytes(charset));
    output.close();

    // Check the error stream first, if this is null then there have been no issues with the request
    InputStream inputStream = connection.getErrorStream();
    if (inputStream == null)
        inputStream = connection.getInputStream();

    // Read everything from our stream
    BufferedReader responseReader = new BufferedReader(new InputStreamReader(inputStream, charset));

    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = responseReader.readLine()) != null) {
        response.append(inputLine);
    }
    responseReader.close();

    return response.toString();
}