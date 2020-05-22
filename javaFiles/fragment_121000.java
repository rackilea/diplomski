// JSON returned for Reddit comments can contain two types of arrays named "children"
// This method checks to see if we were given a Children array or String array
// JSON member "replies" is similar, and can be found in the Data of some Children
// If the method finds a nested "children" array, it recursively adapts its Data
public static Data getGsonAdaptedData(JsonArray childrenJsonArray, Data data) {

    if (childrenJsonArray.size() > 0) {

        Gson gson = new Gson();

        if (childrenJsonArray.get(0).isJsonObject()) {

            data.setChildrenList(gson.fromJson(childrenJsonArray,
                    new TypeToken<List<Children>>() {
                    }.getType()));

            // Loops through every Data object in the array looking for children and replies
            for (int i = 0; i < childrenJsonArray.size(); i++) {

                JsonObject nestedDataJsonObject = childrenJsonArray.get(i).getAsJsonObject().get("data").getAsJsonObject();

                if (nestedDataJsonObject.has("children")) {
                    getGsonAdaptedData(nestedDataJsonObject.get("children").getAsJsonArray(), data.getChildren().get(i).getData());

                } else if (nestedDataJsonObject.has("replies") && nestedDataJsonObject.get("replies").isJsonObject()) {

                    data.getChildren().get(i).getData().setRepliesObject(gson.fromJson(nestedDataJsonObject.get("replies"),
                            new TypeToken<Replies>() {
                            }.getType()));

                    getGsonAdaptedData(nestedDataJsonObject.get("replies").getAsJsonObject().get("data").getAsJsonObject().get("children").getAsJsonArray(), data.getChildren().get(i).getData());
                }
            }
        } else {

            data.setRepliesList(gson.fromJson(childrenJsonArray,
                    new TypeToken<List<String>>() {
                    }.getType()));
        }
    }

    return data;
}