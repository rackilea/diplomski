public void updateData (JSONArray dataset) {
    GsonBuilder gsonb = new GsonBuilder();
    gsonb.registerTypeAdapter(String.class,new Helper_StringAdapter());
    Gson gson = gsonb.create();

    String jsonString = String.valueOf(dataset);
    Type listType = new TypeToken<List<FrameNotification>>(){}.getType();
    notficationsList = (List<FrameNotification>) gson.fromJson(jsonString, listType);
}