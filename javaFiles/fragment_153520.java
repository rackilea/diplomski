private static String authenticateEndpoint = "https://authserver.mojang.com/authenticate";

public static void main(String[] args) throws Exception {
    auth("{\"agent\": { \"name\": \"Minecraft\", \"version\": 1 }, \"username\": \"example\", \"password\": \"password\"}");
}

private static String auth(String data) throws Exception {
    URL url = new URL(authenticateEndpoint);

    byte[] contentBytes = data.getBytes("UTF-8");

    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
    connection.setDoInput(true);
    connection.setDoOutput(true);
    connection.setRequestProperty("Accept-Charset", "UTF-8");
    connection.setRequestProperty("Content-Type", "application/json");
    connection.setRequestProperty("Content-Length", Integer.toString(contentBytes.length));

    OutputStream requestStream = connection.getOutputStream();
    requestStream.write(contentBytes, 0, contentBytes.length);
    requestStream.close();

    String response;
    BufferedReader responseStream;
    if (connection.getResponseCode() == 200) {
        responseStream = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
    } else {
        responseStream = new BufferedReader(new InputStreamReader(connection.getErrorStream(), "UTF-8"));
    }

    response = responseStream.readLine();
    responseStream.close();

    if (connection.getResponseCode() == 200) {
        return response;
    } else {
        // Failed to log in; response will contain data about why
        System.err.println(response);
        return null;
    }
}