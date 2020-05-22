btn_volley.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String username="test";//you can get username and password from edittexts
        String password="123";

        String URL = "http://192.168.0.130:1010/api/CRM/check_login?username="+username+"&password="+password;

        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "test",Toast.LENGTH_LONG).show();
                } else {
                       Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                }
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                       Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
            }
        };

        StringRequest request = new StringRequest(Request.Method.POST, URL, listener, errorListener);

        AppController.getInstance().addToRequestQueue(request);

    }
});