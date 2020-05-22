URL url;
InputStream is = null;
DataInputStream dis;
String line;

try {
    url = new URL("https://stackoverflow.com/");
    is = url.openStream();  // throws an IOException
    dis = new DataInputStream(new BufferedInputStream(is));

    while ((line = dis.readLine()) != null) {
        System.out.println(line);
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