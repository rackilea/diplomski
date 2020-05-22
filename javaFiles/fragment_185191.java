private void jsonTest() {
    try {
        String jsonString = "{\"success\":1,\"message\":\"Post Available!\",\"posts\":[{\"post_id\":\"1\",\"username\":\"hasni\",\"title\":\"titre\",\"message\":\"this is my message\"},{\"post_id\":\"2\",\"username\":\"user2\",\"title\":\"titre 2\",\"message\":\"this is my message 2\"},{\"post_id\":\"3\",\"username\":\"123\",\"title\":\"12\",\"message\":\"111\"},{\"post_id\":\"4\",\"username\":\"1212\",\"title\":\"1212\",\"message\":\"1212\"},{\"post_id\":\"5\",\"username\":\"1212\",\"title\":\"bonjour\",\"message\":\"voila ce message qui vient d'une session \"},{\"post_id\":\"6\",\"username\":\"121212\",\"title\":\"titre\",\"message\":\"message\"}]}";

        Log.i(TAG, "jsonString = " + jsonString);
        JSONObject json = new JSONObject(jsonString);
        int success = json.getInt("success");

        Log.d("ok", "ok");

        if (success == 1) {

            JSONArray messagesArray = (JSONArray) json
                    .getJSONArray("posts");
            for (int i = 0; i < messagesArray.length(); i++) {
                Log.d("iteration", "iteration" + i);
                JSONObject messageJson = messagesArray.getJSONObject(i);
                Log.d("post_id",
                        "post_id: " + i + " "
                                + messageJson.getString("post_id"));
                Log.d("username",
                        "username: " + i + " "
                                + messageJson.getString("username"));
                Log.d("title",
                        "title: " + i + " "
                                + messageJson.getString("title"));
                Log.d("message",
                        "message: " + i + " "
                                + messageJson.getString("message"));
            }

        } else {
            Log.d("failed", "!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }
}