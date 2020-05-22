final GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(JSONObject jsonObject, GraphResponse graphResponse) {
                            try {
                                String name = jsonObject.get("name").toString();
                                Log.d("GraphRequest", "name:" + name);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });