String jsonString = "[[\"Air Fortress\",\"5639\"],[\"Altered Beast\",\"6091\"],[\"American Gladiators\",\"6024\"],[\"Bases Loaded II: Second Season\",\"5975\"],[\"Battle Tank\",\"5944\"]]";

List<String> names = new ArrayList<String>();
List<String> ids = new ArrayList<String>();
JSONArray array = new JSONArray(jsonString);
for(int i = 0 ; i < array.length(); i++){
    JSONArray subArray = (JSONArray)array.get(i);
    String name = (String)subArray.get(0);
    names.add(name);
    String id = (String)subArray.get(1);
    ids.add(id);
}

//to convert the lists to arrays
String[] nameArray = names.toArray(new String[0]);
String[] idArray = ids.toArray(new String[0]);