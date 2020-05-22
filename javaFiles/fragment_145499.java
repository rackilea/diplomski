JsonArrayRequest request = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray jsonArray) {
                    String  name, longitude, latitude;
                    for(int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject object = jsonArray.getJSONObject(i);
                            name = object.getString("name");
                            longitude = object.getString("longitude");
                            latitude = object.getString("latitude");
                        } catch (Exception e) {

                        }
                    }
                }
            }, new Response.ErrorListener(){
        @Override
        public void onErrorResponse(VolleyError volleyError) {
            volleyError.printStackTrace();
        }
    });
    AppController.getInstance().addToRequestQueue(request);//this is a singleton class