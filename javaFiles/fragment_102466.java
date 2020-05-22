JSONObject o = new JSONObject(s);

JSONArray arrayOfTests = (JSONArray) ((JSONObject) o.get("Groups")).get("Test");

for (int i = 0; i < arrayOfTests.length(); i++) {
    System.out.println(arrayOfTests.get(i));
}