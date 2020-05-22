InputStream in = null;
String inputFile = "jar:file:/c:/path/to/my.jar!/myfile.txt";
if (inputFile.startsWith("jar:")){
  try {
    inputURL = new URL(inputFile);
    JarURLConnection conn = (JarURLConnection)inputURL.openConnection();
    in = conn.getInputStream();
  } catch (MalformedURLException e1) {
    System.err.println("Malformed input URL: "+inputURL);
    return;
  } catch (IOException e1) {
    System.err.println("IO error open connection");
    return;
  }
}