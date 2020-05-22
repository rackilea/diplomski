private void makeJsonObjReq() {

        Map<String, String> postParam= new HashMap<String, String>();
        postParam.put("email", "xyz@gmail.com");
        postParam.put("password", "somepasswordhere");

    JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.POST,
        You_Url, new JsonObject(postParam),
        new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }
        }) {

    /**
     * Passing some request headers
     * */
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        return headers;
    }
};

// Adding request to request queue
AppController.getInstance().addToRequestQueue(jsonObjReq,tag_json_obj);

// Cancelling request
// ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);       
}