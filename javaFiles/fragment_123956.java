final static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
final Type objectType = new TypeToken<Object>(){}.getType();

JSONObject obj = new JSONObject(result);

Vector<Object> lists = gson.fromJson(obj.toString(), objectType);