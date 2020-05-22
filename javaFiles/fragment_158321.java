public String doGet(String url) throws Exception {


    URL urlObj = new URL(url);
    HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
    conn.setDoOutput(true);

    String line;
    StringBuffer buffer = new StringBuffer();
    BufferedReader reader = new BufferedReader(new InputStreamReader(
            conn.getInputStream()));

    while ((line = reader.readLine()) != null) {
        buffer.append(line);
    }

    reader.close();
    conn.disconnect();

    return buffer.toString();
}