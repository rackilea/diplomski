String webPage = "http://www.myserver.com/myfile.xml";
        String name = "username";
        String password = "password";

        String authString = name + ":" + password;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);

        URL url = new URL(webPage);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);

        try (InputStream stream = urlConnection.getInputStream()) {

            // preparation steps to use docBuilder ....

            Document xmlDatei = docBuilder.parse(stream);

        }