Type listType = new TypeToken<List<String>>() {}.getType();
 List<String> target = new LinkedList<String>();
 target.add("blah");

 Gson gson = new Gson();
 String json = gson.toJson(target, listType);
 List<String> target2 = gson.fromJson(json, listType);