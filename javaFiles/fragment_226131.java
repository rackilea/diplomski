JsonObjectRequest req = new JsonObjectRequest( Request.Method.POST, url,
      new JSONObject(jsonParams),
        new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // Handle response
            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              //   Handle Error
            }
        }) {
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        return headers;
    }
};
AppController.getInstance().addToRequestQueue(req); // AppController is Volley Singleton.