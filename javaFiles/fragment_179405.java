//first convert input string to json array
JSONObject jsonobject = new JSONObject(countriesAsJsonString);

JSONArray jsonArray = jsnobject.getJSONArray("countries");

//then get the type for list and parse using gson as
Type listType = new TypeToken<List<MyClass>>(){}.getType();
List<MyClass> countriesList = new Gson().fromJson(jsonArray, listType);