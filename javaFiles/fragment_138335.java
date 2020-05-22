JSONObject obj = (JSONObject) JSONValue.parse(jsonString);
JSONArray arr = (JSONArray) obj.get("book");
for (int i = 0; i < arr.size(); i++) {
    JSONObject person = (JSONObject) arr.get(i);
    String first = (String) person.get("first");
    String last = (String) person.get("last");
    String age = (String) person.get("age");
    System.out.println("Person " + i +" : first = "+ first + ", last = " + last + ", age = " + age);
}