private static String download(String urlStr) throws IOException {
    URL url = new URL(urlStr);
    String ret = "";
    BufferedInputStream bis = new BufferedInputStream(url.openStream());
    byte[] buffer = new byte[1024];
    int count = 0;
    while ((count = bis.read(buffer, 0, 1024)) != -1) {
        ret += new String(buffer, 0, count);
    }
    bis.close();
    return ret;
}