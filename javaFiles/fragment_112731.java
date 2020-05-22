public static void main(String[] args) throws Exception {
    URL someUrl = new URL("http://your.site.com/yourfile.gz");
    HttpURLConnection someConnection = (HttpUrlConnection) someUrl.openConnection();
    GZIPInputStream someStream = new GZIPInputStream(someConnection.getInputStream());
    FileOutputStream someOutputStream = new FileOutputStream("output.tar");
    byte[] results = new byte[1024];
    int count = someStream.read(results);
    while (count != -1) {
        byte[] result = Arrays.copyOf(results, count);
        someOutputStream.write(result);
        count = someStream.read(results);
    }
    someOutputStream.flush();
    someOutputStream.close();
    someStream.close();
}