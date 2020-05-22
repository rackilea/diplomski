public static Map<String, String> getFacebookFriends(AccessToken accessToken, Profile profile) throws InterruptedException, ExecutionException {
    final Map<String, String> friendsMap = new HashMap<>();

    GraphRequest.Callback gCallback = new GraphRequest.Callback() {
        public void onCompleted(GraphResponse response) {
            JSONObject jGraphObj = response.getJSONObject();
            try {
                JSONArray friendsData = jGraphObj.getJSONArray("data");
                for (int i = 0; i < friendsData.length(); i++) {
                    JSONObject friend = friendsData.getJSONObject(i);
                    String friendId = friend.getString("id");
                    String friendName = friend.getString("name");
                    friendsMap.put(friendId, friendName);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    final GraphRequest graphRequest = new GraphRequest(accessToken, "/me/friends", null, HttpMethod.GET, gCallback);
    // Run facebook graphRequest.
    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            GraphResponse gResponse = graphRequest.executeAndWait();
        }
    });
    t.start();
    t.join();
    return friendsMap;
}