...
Gson gson = new GsonBuilder().registerTypeAdapter(Data.class, (JsonDeserializer<Data>) (arg0, arg1, arg2) -> {
        JsonObject dataJsonObject = arg0.getAsJsonObject();
        Data data = new Gson().fromJson(dataJsonObject, Data.class);
        return RedditUtils.getGsonAdaptedData(dataJsonObject.get("children").getAsJsonArray(), data);
    }).create();
    final Feed responseSubredditFeed = gson.fromJson(jsonString, Feed.class);
...