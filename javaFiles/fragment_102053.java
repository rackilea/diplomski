@Override 
    public void onSuccess(LoginResult loginResult) {
          // get user name and email 
           this.getUserInfo();
        } 
    } 
   ...
}


private void getUserInfo()
{
    final GraphRequest.GraphJSONObjectCallback callback = new GraphRequest.GraphJSONObjectCallback()
    {
        @Override
        public void onCompleted(JSONObject jsonObject, GraphResponse graphResponse)
        {
            if (jsonObject == null)
            {
                return;
            }

            String name = jsonObject.optString("name");
            String email = jsonObject.optString("email");

            // Do something with these data here
        }
    };

    GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), callback);
    Bundle params = graphRequest.getParameters();
    params.putString("fields", "name,email");
    graphRequest.setParameters(params);
    graphRequest.executeAsync();

}