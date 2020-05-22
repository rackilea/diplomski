String url = "https://reqres.in/api/users?page=2";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            JSONObject jsonInnerObject;

                            for (int k = 0; k< jsonArray.length(); k++){

                                jsonInnerObject=new JSONObject(jsonArray.get(k).toString());

                                String site =  jsonInnerObject.getString("first_name"),
                                    network =  jsonInnerObject.getString("last_name");
                                System.out.println("firstname: "+site+"\nLastname: "+network);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);`