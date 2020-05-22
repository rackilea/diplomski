JSONObject json=new JSONObject();
json.put("method", "completeUserLogin");
JSONArray arr= new JSONArray();
arr.put("100408");
json.put("params", arr);

String params=json.toString();