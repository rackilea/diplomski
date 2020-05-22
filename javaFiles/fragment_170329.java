GraphRequest request = GraphRequest.newGraphPathRequest(
  accessToken,
  "/search",
  new GraphRequest.Callback() {
    @Override
    public void onCompleted(GraphResponse response) {
      // Insert your code here
    }
});

Bundle parameters = new Bundle();
parameters.putString("type", "place");
parameters.putString("center", "53,27");
parameters.putString("distance", "30000");
request.setParameters(parameters);
request.executeAsync();