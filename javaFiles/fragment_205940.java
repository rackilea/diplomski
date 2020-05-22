GraphRequest request = GraphRequest.newMeRequest(
        accessToken,
        new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(
                   JSONObject object,
                   GraphResponse response) {
                // Application code
            }
        });
Bundle parameters = new Bundle();
parameters.putString("fields", "id,name,email,birthday");
request.setParameters(parameters);
request.executeAsync();