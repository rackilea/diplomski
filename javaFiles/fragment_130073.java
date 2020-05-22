URL url;
InputStream is = null;
DataInputStream dis;
String line;
String content

try {
    url = new URL("https://stackoverflow.com/");
    is = url.openStream();  // throws an IOException
    dis = new DataInputStream(new BufferedInputStream(is));

    while ((line = dis.readLine()) != null) {
        content += line; // I forgot to add the linebreak here!
        // I added "content += System.getProperty("line.separator");" and it solved my problem
    }
} catch (MalformedURLException mue) {
     mue.printStackTrace();
} catch (IOException ioe) {
     ioe.printStackTrace();
} finally {
    try {
        is.close();
    } catch (IOException ioe) {
        // nothing to see here
    }
}