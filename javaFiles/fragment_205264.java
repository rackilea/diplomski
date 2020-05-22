public class Xenzet {

    public static void main(String[] args) {
        try {
            URL urlForPostRequest = new URL("http://xenzet.com/ds/getrec.php");
            System.out.println("Instantiated new URL: " + urlForPostRequest);
            final long id = 12;
            HttpURLConnection conection = (HttpURLConnection) urlForPostRequest.openConnection();
            conection.setDoOutput(true);
            conection.setRequestMethod("POST");
            conection.setRequestProperty("User-Agent", "Mozilla/5.0");
            conection.getOutputStream().write(("id="+id).getBytes(StandardCharsets.UTF_8));
            conection.connect();

            BufferedInputStream bis = new BufferedInputStream(conection.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int resultBuffer = bis.read();
            while (resultBuffer != -1) {
                bos.write((byte) resultBuffer);
                resultBuffer = bis.read();
            }
            String result = bos.toString();
            System.out.println(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}