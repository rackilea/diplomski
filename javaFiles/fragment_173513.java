class Response {

    @SerializedName("date")
    public long date;

    @SerializedName("changed")
    public boolean changed;

    @SerializedName("data")
    public JsonObject data;

    public void removeDetails() {
        JsonElement items = data.get("items");
        if (!items.isJsonArray()) {
            return;
        }
        JsonArray array = items.getAsJsonArray();
        array.forEach(item -> {
            if (item.isJsonObject()) {
                JsonObject node = item.getAsJsonObject();
                JsonElement view = node.get("view");
                if (view.isJsonObject()) {
                    view.getAsJsonObject().remove("details");
                }
            }
        });
    }
}