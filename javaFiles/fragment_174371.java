String url = "https://graph.facebook.com/oauth/access_token";
    String charset = "UTF-8";
    String grandType = "fb_exchange_token";

    String query = String.format("grant_type=%s&client_id=%s&client_secret=%s&fb_exchange_token=%s",
            URLEncoder.encode(grandType, charset),
            URLEncoder.encode(Constants.FACEBOOK_APP_ID, charset),
            URLEncoder.encode(Constants.FACEBOOK_APP_SECRET, charset),
            URLEncoder.encode(shortToken, charset));
    HttpsURLConnection con = (HttpsURLConnection) new URL(url + "?" + query).openConnection();
    InputStream ins = con.getInputStream();
    InputStreamReader isr = new InputStreamReader(ins);
    BufferedReader in = new BufferedReader(isr);

    String inputLine;
    String result = "";
    while ((inputLine = in.readLine()) != null) {
        System.out.println(inputLine);
        result += inputLine;
    }
    in.close();

    String[] params = result.split("&");
    Map<String, String> map = new HashMap<String, String>();
    for (String param : params) {
        String name = param.split("=")[0];
        String value = param.split("=")[1];
        map.put(name, value);
    }
    String longToken=map.get("access_token");