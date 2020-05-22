final ThreadLocal<JsonObjectRequest> jsonObjectRequest = new ThreadLocal<JsonObjectRequest>() {
    @Override
    protected JsonObjectRequest initialValue() {
        return new JsonObjectRequest(Request.Method.GET, webAdress,
                null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                RESP = response.toString();
                TEXT.setText("Response: " + RESP);
                Log.d("TAG", "onResponse: " + webAdress);
                Log.d("RESP", "onResponse: " + RESP);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                TEXT.setText("That didn't work!");
                Log.d("TAG", "onErrorResponse: " + webAdress);
            }
        });
    }
};