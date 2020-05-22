StringRequest addrequest = new StringRequest(Request.Method.POST, "http://domainname/test/wp-json/wc/v2/cart/add?product_id=28&quantity=14" ,
            new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {

                    Toast.makeText(OrderActivity.this, response, Toast.LENGTH_LONG).show();
                    Log.e("Response", response);

                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(OrderActivity.this, error.toString(), Toast.LENGTH_LONG).show();
            Log.e("Error", error.toString());
        }
    }) {
        @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            Map<String, String> params = new HashMap<String, String>();
            boolean dbempty = helper.checklogin();
            if (!dbempty) {
                params.put("Authorization", "Bearer " + helper.getToken());
            }
            params.put("Content-Type", "application/json");
            return params;
        }
    };
    Controller.getPermission().addToRequestQueue(addrequest);