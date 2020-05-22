JSONArray array = new JSONArray(jsonString);
    for (int i = 0; i < array.length(); i++)
    {
        JSONObject obj= array.getJSONObject(i);

        String id = obj.getString("id");
        String email = obj.getString("email");
}