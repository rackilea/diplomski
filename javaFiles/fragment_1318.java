URL url = new URL(keycloakRootURL + "/realms/" + realmName + "/protocol/openid-connect/token");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

        conn.setRequestProperty("Authorization", "Basic " + clientSecret);
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        String data = "grant_type=refresh_token&refresh_token=" + refreshToken;
        try (OutputStream os = conn.getOutputStream(); BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(os, "UTF-8"))) {
            writer.write(data);
            writer.flush();
        }

        conn.connect();
        StringBuilder responseStr;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String inputLine;
            responseStr = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                responseStr.append(inputLine);
            }
        }
        Object obj = parser.parse(responseStr.toString());
        JSONObject result = (JSONObject) obj;

        accessCreationTime = System.nanoTime();
        return (String) result.get("access_token");