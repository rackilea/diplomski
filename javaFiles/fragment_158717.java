public String connect() {
    String output = null;
    String key = "679820-995fb7";

    try {
      String connectUrlString =
          "http://aviation-edge.com/v2/public/flights?key=" + key + "&limit=3";
      System.out.println("URL String : " + connectUrlString);
      //      URL url = new URL("http://aviation-edge.com/v2/public/flights?key=[key]=3");
      URL url = new URL(connectUrlString);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Accept", "application/json");

      if (conn.getResponseCode() != 200) {
        throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
      }

      BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
      output = response.toString();
    } catch (Exception e) {
      System.out.println("Exception in WeatherApi:- " + e);
    }
    return output;
  }