String json = ...;
final Gson gson = new Gson();

final List<Attachment> attachements = new ArrayList<Attachment>(64);
final JSONObject jsonObj = new JSONObject(json).getJSONObject("attachments");
final Iterator<String> keys = jsonObj.keys();
while(keys.hasNext()) {
    final String key = keys.next();
    attachements.add(gson.fromJson(jsonObj.getJSONObject(key).toString(), Attachment.class);
}

// Do something with attachements