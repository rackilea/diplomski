URL url;
try {
    url = new URL("http://www.techworld.com/security/rss");
    HttpURLConnection httpURLConnection;
    httpURLConnection = (HttpURLConnection) url.openConnection();
    httpURLConnection.connect();
    if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuffer stringBuffer = new StringBuffer();
        try {
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                stringBuffer.append(inputLine).append("\n");
            }
        } finally {
            bufferedReader.close();
        }

        System.out.println(stringBuffer.toString());
        }
} catch (IOException e) {
    e.printStackTrace();
}