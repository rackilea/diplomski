public void onResponse(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("result");
             // toaccess to your json data 
                String title = jsonArray.getString("title");
                // your code 


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }