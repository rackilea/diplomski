final String urlString = "http://www.xyz.com/login.jsp?fname=harry&lname=potter&occupation=actor";
final URL url;
try {
    url = new URL(urlString);
} catch (MalformedURLException ex) {
    throw new RuntimeException(ex);
}
final Properties properties = new Properties();
for (final String param : url.getQuery().split("\\&")) {
    final String[] splitParam = param.split("=");
    properties.setProperty(splitParam[0], splitParam[1]);
}
for (final String key : properties.stringPropertyNames()) {
    System.out.println("Key " + key + " has value " + properties.getProperty(key) + ".");
}
final FileOutputStream fileOutputStream;
try {
    fileOutputStream = new FileOutputStream(new File("My File"));
} catch (FileNotFoundException ex) {
    throw new RuntimeException(ex);
}
try {
    properties.store(fileOutputStream, "Properties from URL '" +urlString + "'.");
} catch(IOException ex) {
    throw new RuntimeException(ex);
} finally {
    try {
        fileOutputStream.close();
    } catch (IOException ex) {
        throw new RuntimeException(ex);
    }

}