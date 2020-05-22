public List<Post> fetchPostsByTag(JumblrClient client, String tagName, long timestamp) {
    if (client == null || tagName == null || tagName.isEmpty()) {
        return null;
    }
    Map<String, String> options = new HashMap<String, String>();
    if (timestamp != 0) {
        options.put("before", timestamp + "");
    }
    List<Post> posts = client.tagged(tagName, options);
    return posts;
}