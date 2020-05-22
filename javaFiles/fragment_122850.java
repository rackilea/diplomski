List<User> list = new ArrayList<User>();
JSONArray jsonArr = new JSONArray(response);

for (int i = 0; i < jsonArr.length(); i++) {
    JSONObject jsonObj = jsonArr.getJSONObject(i);
    ObjectMapper mapper = new ObjectMapper();
    User usr = mapper.readValue(jsonObj.toString(), User.class);      
    list.add(usr);
}