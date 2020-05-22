public static String sendPost(String url, String params) throws Exception {
    URL obj = new URL(url);
    HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

    // Act like a browser
    connection.setUseCaches(false);
    connection.setRequestMethod("POST");
    connection.setRequestProperty("Accept", "application/json");
    connection.setRequestProperty("Connection", "keep-alive");
    connection.setRequestProperty("Content-Length", Integer.toString(params.length()));

    connection.setDoOutput(true);
    connection.setDoInput(true);

    // Send post request
    DataOutputStream out = new DataOutputStream(connection.getOutputStream());
    out.writeBytes(params);
    out.flush();
    out.close();

    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "Windows-1251"));
    StringBuilder response = new StringBuilder();
    String inputLine;

    while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
    }

    in.close();

    return response.toString();
}