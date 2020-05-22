StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
        new Response.Listener<String>() {
            @Override
            public void onResponse(String response) { 
           button.setText("Response is: " + response.substring(0,5532));
            }
        }, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {
        button.setText("That didn't work!");
    },
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError { 
            Map<String, String>  params = new HashMap<String, String>();  
            params.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:47.0) Gecko/20100101 Firefox/47.0");  


            return params;  
    }

});