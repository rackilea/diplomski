Bundle params = new Bundle();
    params.putString("id", id);
    params.putString("fields", "name");

    Request request = new Request(session, "search", params, HttpMethod.GET, new Request.Callback() {
    public void onCompleted(Response response) { try {
  JSONObject res = response.getGraphObject().getInnerJSONObject().getJSONArray("data").getJSONObject(0);
                                    final String name = (String) res.get("name");