loginButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String email = emailText.getEditableText().toString().trim();
        String password = passwordText.getEditableText().toString().trim();

        LOGIN_URL = String.format("%s&email=%s&pw=%s", LOGIN_URL, email, password);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, LOGIN_URL, null, new Response.Listener() {
            @Override
            public void onResponse(JSONObject response) {
                //Success Callback
                successValue = response.getInt("success");
                if (successValue == "1") {
                    Log.d("TAG", "Logged in succesfully");
                    // DO YOUR STUFF
                }
            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Failure Callback
                Log.d("TAG", "Login failed: Wrong email or password");
                // DO YOUR OTHER STUFF
            }
        });

        // Adding the request to the queue along with a unique string tag
        MyApplication.getInstance().addToRequestQueue(jsonObjectReq, "getRequest");
    }
});