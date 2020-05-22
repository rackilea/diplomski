HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.connect();
    int lenghtOfFile = connection.getContentLength();
    Log.d("File Download", "Lenght of file: " + lenghtOfFile);

    InputStream input = new BufferedInputStream(connection.getInputStream());