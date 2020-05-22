try {
        HttpResponse response;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet getConnection = new HttpGet(url);
        try {
            response = httpClient.execute(getConnection);
            String JSONString = EntityUtils.toString(response.getEntity(),
                    "UTF-8");
            JSONObject jsonObject = new JSONObject(JSONString); //Assuming it's a JSON Object

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }