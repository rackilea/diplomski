URL url1 = new URL("YOUR_URL");
        HttpURLConnection request1 = (HttpURLConnection) url1.openConnection();
        request1.setRequestMethod("GET");
        request1.connect();
        String responseBody = convertStreamToString(request1.getInputStream());
        JSONArray jsonArray = new JSONArray(responseBody);
        for (int i = 0; i < jsonArray.length(); i++) {
            String email = jsonArray.getJSONObject(i).getString("Email");
            System.out.println(email);

            //... Similarly you can parse all the objects..
        }