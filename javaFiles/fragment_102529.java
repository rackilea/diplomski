private void initGeofenceNames(){

        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, HttpUrl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i = 0; i < response.length(); i++){

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        Log.d(TAG, "GeofenceManageListActivity: jsonObject called");

                        mGeofenceNames.add(jsonObject.getString("geof_name"));

                        for (String s : mGeofenceNames){
                            mTextNames.add(s.toString());
                        }
    initRecyclerView();

                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "GeofenceManageListActivity: " + error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);

        //mTextNames.add("HARRY POTTER");


    }