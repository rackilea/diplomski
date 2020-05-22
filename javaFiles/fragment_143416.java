private static String getStringResponse() throws Exception {

    URL url = new URL("/api/auth/signup");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", "Mozilla/5.0");
    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
    con.setDoOutput(true);  // Send post request

    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    wr.flush();
    wr.close();

    // int responseCode = con.getResponseCode();
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
    }
    in.close();
    con.disconnect();

    return response.toString();
}

public static void main(String[] args) {
    String response = getStringResponse();
    JSONObject json = new JSONObject(response);
}