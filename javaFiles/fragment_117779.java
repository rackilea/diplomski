private void login(final String email, final String password){
        String LOGIN_REQUEST_URL = "http://localhost/project/index.php/clientapinew/post_login2";

        // JSON data
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("Email", email);
            jsonObject.put("Password", password);
        } catch (JSONException e){
            e.printStackTrace();
        }

        // Json request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                LOGIN_REQUEST_URL,
                jsonObject,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response){
                        //Toast.makeText(context, "Product successfully added", Toast.LENGTH_SHORT).show();
                        try{
                            //use the response JSONObject now like this log
                            Log.d(TAG, response.getString("Success"));
                            boolean success = response.getBoolean("Success");
                            if (success) {
                                //...
                            }
                        } catch (JSONException e) {
                            System.out.println("Error logging in");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                if (error instanceof NetworkError) {
                    Toast.makeText(LoginActivity.this, "Can't connect to Internet. Please check your connection.", Toast.LENGTH_LONG).show();
                }
                else if (error instanceof ServerError) {
                    Toast.makeText(LoginActivity.this, "Unable to login. Either the username or password is incorrect.", Toast.LENGTH_LONG).show();
                }
                else if (error instanceof ParseError) {
                    Toast.makeText(LoginActivity.this, "Parsing error. Please try again.", Toast.LENGTH_LONG).show();
                }
                else if (error instanceof NoConnectionError) {
                    Toast.makeText(LoginActivity.this, "Can't connect to internet. Please check your connection.", Toast.LENGTH_LONG).show();
                }
                else if (error instanceof TimeoutError) {
                    Toast.makeText(LoginActivity.this, "Connection timed out. Please check your internet connection.", Toast.LENGTH_LONG).show();
                }

                //Do other stuff if you want
                error.printStackTrace();
            }
        }){

            @Override
            public Map<String,String> getHeaders() throws AuthFailureError {
                Map<String,String> headers = new HashMap<String,String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                3600,
                0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        RequestQueueSingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }