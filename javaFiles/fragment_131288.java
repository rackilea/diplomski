// Open connection to URL.
HttpURLConnection connection = (HttpURLConnection) url.openConnection();

// Specify what portion of file to download.
connection.setRequestProperty("Range", "bytes=" + downloaded + "-");
// here "downloaded" is the data length already previously downloaded.

// Connect to server.
connection.connect();