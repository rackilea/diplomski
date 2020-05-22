@ResponseBody
    @RequestMapping("/")
    public String index() {

        JSONObject json = new JSONObject();

        try {
            AppServiceMSICredentials credential = new AppServiceMSICredentials(AzureEnvironment.AZURE);
            // As we want to get token for accessing the aad-protected app, change the
            // resource to the client ID you get in step 2
            String token = credential.getToken("ac07d701-6f7d-462e-8b67-5dffa1df955f");
            json.put("token", token);

            // The URL for app1 API
            String app1 = "https://jackdemoapp1.azurewebsites.net/app1/";
            HttpURLConnection conn = (HttpURLConnection) new URL(app1).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + token);
            conn.setDoOutput(true);
            conn.setDoInput(true);

            // Open the connection
            conn.connect();

            int code = conn.getResponseCode();
            if (code >= 200 && code <= 300) {
                try (InputStream inputStream = conn.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String line = "";

                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }

                    String response = stringBuilder.toString();
                    json.put("response", response);
                }
            } else {
                json.put("Error", "Response Code" + conn.getResponseCode());
            }
            conn.disconnect();

        } catch (Exception e) {
            json.put("Exception", e.getStackTrace());
        }
        return json.toString();
    }