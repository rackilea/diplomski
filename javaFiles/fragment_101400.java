public List<Demon> deserialize(String json) {
    try {
        JSONObject jsonObject = new JSONObject(json);


        final JSONArray names = jsonObject.names();
        final List<Demon> demons = new ArrayList<>();
        final Gson gson = new Gson();
        Demon demon;
        for (int i = 0; i < names.length(); i++) {
            demon = gson.fromJson(jsonObject.get(names.getString(i)).toString(), Demon.class);
            demons.add(demon);
        }

        return demons;

    } catch (JSONException e) {
        e.printStackTrace();
        return null;
    }
}