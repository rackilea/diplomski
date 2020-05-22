loginButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String email = emailText.getEditableText().toString().trim();
        String password = passwordText.getEditableText().toString().trim();

        // Create a JSONObject for adding parameters to the POST Request
        JSONObject postparams = new JSONObject();
        postparams.put("email", email);
        postparams.put("pw", password);

        // Creating the post request object
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, MAIN_URL, postparams,
            new Response.Listener() {
                @Override
                public void onResponse(JSONObject response) {
                    //Success Callback
                    successValue = response.getInt("success");
                    if (successValue == "1") {
                        Log.d("TAG", "Logged in succesfully");
                        // DO YOUR STUFF
                    }
                    else {
                        Log.d("TAG", "Login failed: Wrong email or password");
                        // DO YOUR OTHER STUFF
                    }
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    //Failure Callback
                    Log.d("TAG", "Error posting request: "+error.toString());
                }
            });

        // Adding the request to the queue along with a unique string tag
        MyApplication.getInstance().addToRequestQueue(jsonObjectReq, "postRequest");       
    }
});