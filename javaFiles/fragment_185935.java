try {
    JSONObject response = new JSONObject(result);

    JSONObject feed_object = response.getJSONObject("feed");

    JSONArray items_arr = response.getJSONArray("items");
    for (int i = 0; i < items_arr.length(); i++) {
        JSONObject post = items_arr.getJSONObject(i);
        PostItems item = new PostItems();
        item.setAuthor(feed_object.getString("title")); // being fetched from top node
        item.setTitle(post.getString("title")); // being fetched from array
        item.setDate(post.getString("pubDate")); // being fetched from array

        feedItem.add(item);
    }

}