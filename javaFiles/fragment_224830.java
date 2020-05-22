if(!queryResults.isEmpty()) {
  JsonObject facebookPost = queryResults.get(0);
  String message = facebookPost.getString("message");
  if(null != message && !"".equals(message)) {
    // Do whatever you're trying to do with the message here
  }
  // Follow the same pattern for timeline_visibility
}