Gson gson = new Gson();
//read both jsons
Map<String, Object> json1 = gson.fromJson("<json1>", Map.class);
Map<String, Object> json2 = gson.fromJson("<json2>", Map.class);
//create combined json with contents of first json
Map<String, Object> combined = new HashMap<>(json1);
//Add the contents of first json. It will overwrite the values of keys are 
//same. e.g. "foo" of json2 will take precedence if both json1 and json2 have "foo" 
combined.putAll(json2);
gson.toJson(combined);