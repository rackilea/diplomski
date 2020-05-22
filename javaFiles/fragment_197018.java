private void connect() {
    String data;
    JSONArray json;
    try {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(
                "http://demo.tugain.com/tapme/RetriveAll.php?q=cat");
        HttpResponse response = client.execute(request);
        HttpEntity entity = response.getEntity();
        data = EntityUtils.toString(entity);
        Log.e("STRING", data);

        try {
            JSONObject obj = null;

            json = new JSONArray(data);
            JSONArray actualJson = json.getJSONArray(0);

            for (int i = 0; i < actualJson.length(); i++) {
                obj = actualJson.getJSONObject(i);

                String name = obj.getString("name");
                Log.e("STRING", name);
                // mAdapter.addSectionHeaderItem(name);
                // setListAdapter(mAdapter);

                // JSONArray json1=new JSONArray("data");
                JSONArray json1 =obj.getJSONArray("data");

                for (int j = 0; j < json1.length(); j++) {

                JSONObject obj1= json1.getJSONObject(j);
                    String CompName= obj1.getString("vendor_name");

                    Log.e("STRING", CompName);
                    // CompID=obj1.getString("vendor_id");
                    // Log.e("vender",CompName);
                    // Log.e("id",CompID);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    } catch (ClientProtocolException e) {
        Log.d("HTTPCLIENT", e.getLocalizedMessage());
    } catch (IOException e) {
        Log.d("HTTPCLIENT", e.getLocalizedMessage());
    }
}