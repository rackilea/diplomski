final ProgressDialog loading = ProgressDialog.show(SettingsActivity.this,"Uploading...","Please wait...",false,false);
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "REMOVED",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String s) {
                                    //Dismissing the progress dialog
                                    loading.dismiss();
                                    //Showing toast message of the response
                                    try {
                                        JSONObject jsonObject = new JSONObject(s);
                                        int responseCode = Integer.parseInt(jsonObject.getString("responseCode"));
                                        String response = jsonObject.getString("response");
                                        if (responseCode == 1) {
                                            Toast.makeText(SettingsActivity.this, response, Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(SettingsActivity.this, "Error: " + response, Toast.LENGTH_LONG).show();
                                        }
                                    } catch (Exception ex) {
                                        Toast.makeText(SettingsActivity.this, "Failed to upload.", Toast.LENGTH_LONG).show();
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError volleyError) {
                                    //Dismissing the progress dialog
                                    loading.dismiss();

                                    //Showing toast
                                    try {
                                        JSONObject jsonObject = new JSONObject(volleyError.getMessage());
                                        int responseCode = Integer.parseInt(jsonObject.getString("responseCode"));
                                        String response = jsonObject.getString("response");
                                        if (responseCode == 1) {
                                            Toast.makeText(SettingsActivity.this, response, Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(SettingsActivity.this, "Error: " + response, Toast.LENGTH_LONG).show();
                                        }
                                    } catch (Exception ex) {
                                        Toast.makeText(SettingsActivity.this, "Failed to upload.", Toast.LENGTH_LONG).show();
                                    }
                                }
                            }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            //Converting Bitmap to String
                            String image = Memer.getMemer().toBase64(bitmap);

                            //Getting Image Name

                            //Creating parameters
                            Map<String,String> params = new Hashtable<>();

                            //Adding parameters
                            params.put("base64", image);

                            //returning parameters
                            return params;
                        }
                    };

                    //Creating a Request Queue
                    RequestQueue requestQueue = Volley.newRequestQueue(SettingsActivity.this);

                    //Adding request to the queue
                    requestQueue.add(stringRequest);