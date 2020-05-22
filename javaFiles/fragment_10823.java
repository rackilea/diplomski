String first = ("https://stackoverflow.com/questions");
    String second = ("/48545905/putting-2-strings-together-to-build-url-with-resultset");

    String url = (first+second);

    URL obj = null;
    try {
        obj = new URL(url);
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }

    HttpsURLConnection con = null;
    try {
        con = (HttpsURLConnection) obj.openConnection();
    } catch (IOException e) {
        e.printStackTrace();
    }

    int  responseCode = con.getResponseCode();
    System.out.println("\nSending 'GET' request to URL : " +url);
    System.out.println("Response Code : " + responseCode);


    BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer content = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
    }
    System.out.println(content);
    in.close();
    con.disconnect();