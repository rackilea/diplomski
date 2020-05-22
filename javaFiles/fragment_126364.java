try {
            HttpPost httpPost = new HttpPost("https://exampleurl/providerexample/api/v1/loansforexample"
            );
            StringEntity params;
            params = new StringEntity("{"
                    + "\"clientId\": \"" + "2" + "\","
                    + "\"productId\": \"" + "1" + "\"," 
                    + "\"locale\": \"" + "en" + "\"}");

            httpPost.addHeader("Content-Type", "text/html"); //or text/plain
            httpPost.addHeader("Accept-Encoding", "gzip, deflate, sdch");
            httpPost.setEntity(params);
            HttpResponse response = client.execute(httpPost);
            int statuscode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(response.getEntity());
            if (statuscode == 200) {
                System.out.println(responseBody);
            }
            if (statuscode != 200) {
                System.out.println(responseBody);
//                JSONObject obj = new JSONObject(responseBody);
//                JSONArray errors = obj.getJSONArray("errors");
//                String errorMessage = "";
//                if (errors.length() > 0) {
//                    errorMessage = errors.getJSONObject(0).getString("developerMessage");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            ex.getMessage();
        }