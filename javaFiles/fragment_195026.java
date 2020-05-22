public EarthImageryResponseObject earthImagery(double lon, double lat, String year, String mon, String day, boolean cloud_score) {
    String cs;
    if(cloud_score) cs = "True";
    else cs = "False";
    String url = "https://api.nasa.gov/planetary/earth/imagery?lon="
            + lon
            + "&lat=" 
            + lat
            + "&date="
            + year+"-"+mon+"-"+day
            + "&cloud_score="
            + cs 
            + "&api_key=" + api_key;
    try {
        HttpURLConnection conn = getConnection(url);
        String new_url = conn.getHeaderField("Location");
        SSLSocketFactory factory =
                    (SSLSocketFactory)SSLSocketFactory.getDefault();
        SSLSocket socket =
                    (SSLSocket)factory.createSocket("api.nasa.gov", 443);
        socket.startHandshake();
        socket.getOutputStream().write(("GET "+new_url+"\n").getBytes());
        BufferedReader in = new BufferedReader(
                                        new InputStreamReader(
                                        socket.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null)
                    sb.append(inputLine);
        in.close();
        socket.close();
        String json = sb.toString();
        System.out.println(json);
        return gson.fromJson(json, EarthImageryResponseObject.class);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}