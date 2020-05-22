for (int i = 0; i < hotTopics.length(); i++) {
    JSONObject topic = hotTopics.getJSONObject(i).getJSONObject("data");

    String author = topic.getString("author");
    String imageUrl = topic.getString("thumbnail");
    String postTime = topic.getString("created_utc");
    String rScore = topic.getString("score");
    String title = topic.getString("title");

    topicdata.add(new ListData(title, author, imageUrl, postTime, rScore));
    Log.v(DEBUG_TAG, topicdata.toString());
}