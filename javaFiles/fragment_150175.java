JSONObject json = new JSONObject(jsonString);
JSONObject photos = json.getJSONObject("photos");
JSONArray photo = photos.getJSONArray("photo");
if (photo.length() > 0) {
    JSONObject first = photo.getJSONObject(0);
    String picOwner = first.getString("owner");
    String picID = first.getString("id");
}