String fileURL="https://tools.keycdn.com/geo.json?host=192.168.6.9";
URL url;
    try
    {
        final String USER_AGENT = "Mozilla/5.0";
        url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        // optional default is GET
        httpConn.setRequestMethod("GET");
        //add request header
        httpConn.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = httpConn.getResponseCode();
        System.out.println(responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(httpConn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print result
        System.out.println(response.toString());

    }
    catch (Exception e)
    {
        e.printStackTrace();
    }