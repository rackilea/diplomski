public class DownloadMain {
    public static void main(String[] args) throws IOException {
        HttpURLConnection uri = (HttpURLConnection) new URL("http://speedtest.tele2.net/3MB.zip").openConnection();
        uri.setRequestMethod("GET");
        uri.setConnectTimeout(5000);
        InputStream ent = uri.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = new byte[8192];
        long start = System.currentTimeMillis();
        for (int len; (len = ent.read(bytes)) > 0; )
            baos.write(bytes, 0, len);
        long time = System.currentTimeMillis() - start;
        System.out.printf("Took %.3f seconds to read %.3f MB of data%n",
                time / 1e3, baos.toByteArray().length / 1e6);
    }
}