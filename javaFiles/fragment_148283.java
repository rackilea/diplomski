JSONObject object = new JSONObject();
object.put("name", "sample");
JSONArray array = new JSONArray();

JSONObject arrayElementOne = new JSONObject();
arrayElementOne.put("setId", 1);
JSONArray arrayElementOneArray = new JSONArray();

JSONObject arrayElementOneArrayElementOne = new JSONObject();
arrayElementOneArrayElementOne.put("name", "ABC");
arrayElementOneArrayElementOne.put("type", "STRING");

JSONObject arrayElementOneArrayElementTwo = new JSONObject();
arrayElementOneArrayElementTwo.put("name", "XYZ");
arrayElementOneArrayElementTwo.put("type", "STRING");

arrayElementOneArray.put(arrayElementOneArrayElementOne);
arrayElementOneArray.put(arrayElementOneArrayElementTwo);

arrayElementOne.put("setDef", arrayElementOneArray);
array.put(arrayElementOne);
object.put("def", array);