final Bundle parameters = new Bundle();
parameters.putString("firstname", "Robert");
parameters.putString("lastname", "Smith");

/* make the API call */
new GraphRequest(
    AccessToken.getCurrentAccessToken(),
    "/{user-id}",
    parameters,
    HttpMethod.POST,
    new GraphRequest.Callback() {
        public void onCompleted(GraphResponse response) {
            /* handle the result */
        }
    }
).executeAsync();