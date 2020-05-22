public static void main(String args[]) throws Exception{
    URL url = new URL("http://sentiment.vivekn.com/api/batch/");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setConnectTimeout(5000);//5 secs
    connection.setReadTimeout(5000);//5 secs

    connection.setRequestMethod("POST");
    connection.setDoOutput(true);
    connection.setRequestProperty("Content-Type", "application/json");

    OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());  
    out.write(
            "[ " +
            "\"the fox jumps over the lazy dog\"," +
            "\"another thing here\" " +
            "]");
    out.flush();
    out.close();

    int res = connection.getResponseCode();

    System.out.println(res);


    InputStream is = connection.getInputStream();
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    String line = null;
    while((line = br.readLine() ) != null) {
        System.out.println(line);
    }
    connection.disconnect();

}