RequestQueue queue = Volley.newRequestQueue(this);

private void makeJsonObjReq() {
    Map<String, String> postParam= new HashMap<String, String>();
    postParam.put(name1,Name);
    postParam.put(client_id1,CID);
    postParam.put(email1,Email);
    postParam.put(mobile1,Mobile);
    postParam.put(password1,Password);
    postParam.put(device_id1,"123456");

    JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.PUT,
        Const.YOUR_URL, new JSONObject(postParam),
        new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                msgResponse.setText(response.toString());
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        }) {

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        return headers;
    }
};

jsonObjReq.setTag(TAG);
queue.add(jsonObjReq);