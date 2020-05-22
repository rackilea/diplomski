private static String sendPost(String url, Map<String, JSONObject> params) throws Exception {
    String responseString;

    StringBuilder urlParameters = new StringBuilder(400);
    if (params != null) {
        for (Entry<String, JSONObject> entry : params.entrySet()) {
            urlParameters.append(entry.getKey()).append("=").append(entry.getValue().toString()).append("&");
        }
    }

    url = url.replace(" ", "%20");
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("POST");
    con.setRequestProperty("accept-charset", "UTF-8");
    con.setRequestProperty("content-type", "application/x-www-form-urlencoded; charset=utf-8");
    con.setDoOutput(true);

    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(wr, "UTF-8"));
    writer.write(urlParameters.toString());
    writer.close();
    wr.close();

    int responseCode = con.getResponseCode();
    if (responseCode == HttpStatus.SC_OK) {
        BufferedReader in = null;
        StringBuffer response = null;
        try{
            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String inputLine;
            response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }finally{
            in.close();
        }
        responseString = response.toString();
    } else {
        responseString = new StringBuilder(25).append(responseCode).toString();
    }
    return responseString;
}