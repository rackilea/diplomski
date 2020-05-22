public class DownloadMain {
    public static void main(String[] args) throws IOException {
        HttpURLConnection uri = (HttpURLConnection) new URL("http://speedtest.tele2.net/3MB.zip").openConnection();
        uri.setRequestMethod("GET");
        uri.setConnectTimeout(5000);
        InputStream ent =uri.getInputStream();
        Reader reader = new InputStreamReader(ent, StandardCharsets.ISO_8859_1);
        StringWriter sw = new StringWriter();
        char[] chars = new char[8192];
        long start = System.currentTimeMillis();
        for (int len; (len = reader.read(chars)) > 0; )
            sw.write(chars, 0, len);
        long time = System.currentTimeMillis() - start;
        System.out.printf("Took %.3f seconds to read %.3f MB of data%n",
                time / 1e3, sw.toString().length() / 1e6);
    }
}