for (Status tweet : tweets) {

    JSONObject obj = new JSONObject();

    obj.put("userName", tweet.getUser().getScreenName());
    obj.put("text", tweet.getText());
    final GeoLocation location  = tweet.getGeolocation();
    if(location != null) {
       obj.put("lat", location().getLatitude());
       obj.put("lon", location().getLongitude());
    }
    String json = obj.toString();
    array.put(obj);
}