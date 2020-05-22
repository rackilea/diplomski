BufferedReader reader = null;
String firstLine = null;

try {
    InputStream stream = ftpClient.retrieveFileStream(ftpFile.getName());
    reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
    firstLine = reader.readLine();
} finally {
    if (reader != null) try { reader.close(); } catch (IOException logOrIgnore) {}
}

doYourThingWith(firstLine);