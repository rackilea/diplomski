String fqlQuery = "SELECT uid, name, pic_square FROM user WHERE uid IN "
            + "(SELECT uid2 FROM friend WHERE uid1 = me() )";
    Bundle params = new Bundle();
    params.putString("q", fqlQuery);
    Session session = Session.getActiveSession();
    Request request = new Request(session, "/fql", params, HttpMethod.GET,
            new Request.Callback() {
                public void onCompleted(Response response) {
                    Log.i(TAG, "Result: " + response.toString());

                    try {
                        final GsonBuilder builder = new GsonBuilder();
                        final Gson gson = builder.create();
                        **//here i get Data values** 
                        JSONObject data = response.getGraphObject()
                                .getInnerJSONObject();
                        FacebookResponses facebookResponses = gson
                                .fromJson(data.toString(),
                                        FacebookResponses.class);

                        Intent i = new Intent(getActivity()
                                .getApplicationContext(),
                                FacebookUsersImages.class);
                        i.putExtra("facebookResponses", facebookResponses);
                        startActivity(i);

                        // Log.i(TAG, "Result finale : " +
                        // facebookResponses.toString());
                    } catch (JsonSyntaxException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
    Request.executeBatchAsync(request);