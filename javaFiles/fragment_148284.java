JSONObject object = new JSONObject();
object.element("name", "sample");
JSONArray array = new JSONArray();

JSONObject arrayElementOne = new JSONObject();
arrayElementOne.element("setId", 1);
JSONArray arrayElementOneArray = new JSONArray();

JSONObject arrayElementOneArrayElementOne = new JSONObject();
arrayElementOneArrayElementOne.element("name", "ABC");
arrayElementOneArrayElementOne.element("type", "STRING");

JSONObject arrayElementOneArrayElementTwo = new JSONObject();
arrayElementOneArrayElementTwo.element("name", "XYZ");
arrayElementOneArrayElementTwo.element("type", "STRING");

arrayElementOneArray.add(arrayElementOneArrayElementOne);
arrayElementOneArray.add(arrayElementOneArrayElementTwo);

arrayElementOne.element("setDef", arrayElementOneArray);
object.element("def", array);