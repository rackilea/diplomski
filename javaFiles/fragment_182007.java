LoginManager.getInstance().registerCallback(callbackManager,
        new FacebookCallback<LoginResult>(){
        @Override
        public void onSuccess(final LoginResult loginResult){
                GraphRequest request=GraphRequest.newMeRequest(
                loginResult.getAccessToken(),
                new GraphRequest.GraphJSONObjectCallback(){
        @Override
        public void onCompleted(
                JSONObject object,
                GraphResponse response){
                if(response.getError()!=null){
                // handle error
                }else{
                //**access details as follows**
                String email=object.optString("email");
                String first_name=object.optString("first_name");
                String last_name=object.optString("last_name");

                }
                });

                Bundle parameters=new Bundle();
                parameters.putString("fields","id,first_name,last_name,email,gender,birthday");
                request.setParameters(parameters);
                request.executeAsync();
                }

        @Override
        public void onCancel(){
                //Toast.makeText(context, "Something went wrong. Please try again",
                // Toast.LENGTH_SHORT).show();
                }

        @Override
        public void onError(FacebookException exception){
                //Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                exception.printStackTrace();
                }
});