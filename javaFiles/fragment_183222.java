JSONObject last = new JSONObject();

if(s == 200) {
    HttpEntity e = response.getEntity();
    String data = EntityUtils.toString(e);
    JSONArray posts = new JSONArray(data);
    last = posts.getJSONObject(0);
}

return last;