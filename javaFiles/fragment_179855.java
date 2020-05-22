String finalJson = buffer.toString();

JSONObject parentObject = new JSONObject((finalJson));

//JSONObject finalObj = parentObject.getJSONObject("value");
JSONArray jokeArray = parentObject.getJSONArray("value");

Random r = new Random();
String joke1 = jokeArray.getJSONObject(r.nextInt(jokeArray.length())).getString("joke");
String joke2 = jokeArray.getJSONObject(r.nextInt(jokeArray.length())).getString("joke");