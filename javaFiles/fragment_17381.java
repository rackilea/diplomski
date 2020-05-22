MyClass obj = new MyClass();
Gson gson = new Gson();
JSONObject onj = new JSONObject();
        JSONArray userDataValues = new JSONArray();
//again convert to json
userDataValues.put(new JSONObject(gson.toJson(obj)));
//serialized the object
onj.put("property", userDataValues);