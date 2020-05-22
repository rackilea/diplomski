String url = "http://example.com:8090/CMD";

StringRequest myStringRequest = new StringRequest(Request.Method.POST, url,
        new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "application/json");
        return headers;
    }

    @Override
    public String getBodyContentType() {
        return "text/plain";
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        String httpPostBody = "ON";
        return httpPostBody.getBytes();
    }
};
RequestQueue MyRequestQueue = Volley.newRequestQueue(this);
myStringRequest.setShouldCache(false);
MyRequestQueue.add(myStringRequest);