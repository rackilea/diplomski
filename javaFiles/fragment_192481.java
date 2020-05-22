LoginManager.getInstance().registerCallback(callbackManager,new FacebookCallback<LoginResult>() {
     @Override
      public void onSuccess(LoginResult loginResult) {
      Log.d("tag","FF fb onSuccess");
      GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(),new GraphRequest.GraphJSONObjectCallback() {
        @Override
        public void onCompleted(JSONObject object,GraphResponse response) {
         try {
               String[] splited ;
               JSONObject obj =  object.getJSONObject("picture").getJSONObject("data");

                                  if (object.has("birthday"))
                                  {
                                     Birthday =  object.getString("birthday");
                                  }
                                  else
                                  {
                                      Birthday = "";
                                  }



                                } catch (JSONException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }


                                }
                            });
                    Bundle parameters = new Bundle();
                    parameters.putString("fields", "id,name,link,birthday,picture,email,gender");
                    request.setParameters(parameters);
                    request.executeAsync();


                }

                @Override
                public void onCancel() {
                    Log.d("tag","fb onCancel");
                     // App code
                }



    @Override
                public void onError(FacebookException exception) {
                    Log.d("tag","fb onError");
                     // App code   
                }
    });