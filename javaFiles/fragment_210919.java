public static void main(String[] args) throws IOException {

    String response1 = sendGET("http://url1");
    if(response1 != null && response1.contains("true")){
        String response2 = sendGET("http://url2");
    }

}

private static String sendGET(String url) throws IOException {
    URL obj = new URL(url);
    StringBuffer response = new StringBuffer();
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("GET");
    int responseCode = con.getResponseCode();
    System.out.println("GET Response Code :: " + responseCode);
    if (responseCode == HttpURLConnection.HTTP_OK) { // success
        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // print result
        System.out.println(response.toString());
    } else {
        System.out.println("GET request not worked");
    }
    return response.toString();
}