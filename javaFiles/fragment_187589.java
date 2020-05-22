JSONObject idJSONObject = obj.getJSONObject("id");
if (idJSONObject != null) {
    if (idJSONObject.hasElement("videoId)) {
        videoId = idJSONObject.getString("videoId");
    }
}