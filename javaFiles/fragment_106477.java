public class HttpPut {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        URL url = new URL("http://fltspc.itu.dk/widget/515318fe17450f312b00153d/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
        osw.write(String.format("{\"pos\":{\"left\":%1$d,\"top\":%2$d}}", random.nextInt(30), random.nextInt(20)));
        osw.flush();
        osw.close();
        System.err.println(connection.getResponseCode());
    }
}