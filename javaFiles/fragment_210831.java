JsonObjectRequest jsonObject = new JsonObjectRequest(Request.Method.GET,
        url,
        jObject,
        new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.v(TAG, "Vultus Get Resposne Version2: " + response.toString());

                try{
                    //String jsonStr = response.toString();
                    JSONObject jsonObj = new JSONObject(response);

                    JSONArray jsonData = jsonObj.getJSONArray("output");
                    int length = jsonData.length();

                    ArrayList<String> urls = new ArrayList<>();
                    for(int i = 0; i < length; i++) {
                        String url = jsonData.getString(i);
                        urls.add(url);
                    }
                } catch(JSONException e) {
                    e.printStackTrace();
                }
            }
        }