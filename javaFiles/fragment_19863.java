loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() 
{
 @Override
 public void onSuccess (final LoginResult loginResult)
 { 
    GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback()
      { 
                            @Override
                            public void onCompleted (JSONObject object, GraphResponse response) 
                            {
                                try
                                {  
                                 String id = response.getJSONObject().getString("id");
     ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(passwordEditText.getWindowToken(), 0);
                
             if (connect()) 
             {   
                /*ENTER*/   
             }   
             else
             {
              Toast.makeText(getApplicationContext(), textProblemConnecting(), Toast.LENGTH_LONG).show();
             } 
        }
                                catch (JSONException e)
                                {
         e.printStackTrace();
        } 
                            }
                  });
                  Bundle parameters = new Bundle();
                  parameters.putString("YOUR FIELDS");
                  request.setParameters(parameters);
                  request.executeAsync();
              }
        
           @Override
           public void onCancel ()
           {
           
           }
        
           @Override
           public void onError (FacebookException e) 
           {
           
           }
       });