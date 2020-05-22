public List<Map<String, String>> json_string_to_listmap(String json){   
    Gson gson = new Gson();
    Type type = new TypeToken<ArrayList<Map<String, String>>>() {}.getType();
    // Use fromJson method to deserialize json into an ArrayList of Map
    return gson.fromJson(json , type);
}