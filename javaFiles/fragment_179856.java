String finalJson = buffer.toString();

JSONObject parentObject = new JSONObject((finalJson));

//JSONObject finalObj = parentObject.getJSONObject("value");
JSONArray jokeArray = parentObject.getJSONArray("value");

Random r = new Random();
int id1 = r.nextInt(jokeArray.length())
String joke1 = jokeArray.getJSONObject(id1).getString("joke");

int id2 = r.nextInt(jokeArray.length())
String joke2 = jokeArray.getJSONObject(id1).getString("joke");

String joke1WithID = id1 + "  " + joke1
String joke2WithID = id2 + "  " + joke2