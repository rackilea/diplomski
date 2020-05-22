public void getMethod() throws IOException
    {
        String userAgent = "Java/" + Runtime.class.getPackage().getImplementationVersion();
        //The server will need to know what "question" we are answering so it sent us the captha and a sesion ID
        //example is just a random one you will need to figure out how to get a sesion id
        String captchaSesionParam = "captchaSesionID=";
        String captchaSesionID = UUID.randomUUID().toString();
        //user has completed captha client side here is their answer
        String queryParam = "answer=";
        String answer = "blah blah answer";
        String urlString = "https://127.0.0.1/?" + queryParam + URLEncoder.encode(answer, "UTF-8") + "&" + captchaSesionParam + URLEncoder.encode(captchaSesionID, "UTF-8");

        URL url = new URL(urlString);
        //Open a HTTPS connection to the URL
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        //set request method to GET
        con.setRequestMethod("GET");
        //set user agent to our agent (by default I believe that this is 'Java/Version')
        con.setRequestProperty("User-Agent", userAgent);

        //print out debug info about request method and url
        System.out.println(con.getRequestMethod() + " URL : " + url);
        int responseCode = con.getResponseCode();
        System.out.println("Server response code: " + responseCode);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));)
        {
            String line;
            List<String> lines = new ArrayList<String>();

            while ((line = in.readLine()) != null)
            {
                lines.add(line);
            }
            //parse lines received from server to see if the captcha was (in)correct

            //print lines for debug
            for(String l : lines)
            {
                System.out.println(l);
            }
        }
    }