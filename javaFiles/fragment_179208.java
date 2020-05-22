final String jsonObj = new JSONObject(json).getJSONObject("attachments");
final Gson gson = new Gson();
final Map<String, Attachment> data = gson.fromJson(jsonObj.toString(),
        new TypeToken<Map<String, Attachment>>() {
        }.getType());
final List<Attachment> attachments = new ArrayList<Attachment>(data.values());