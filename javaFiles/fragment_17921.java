JSONObject topLevel = new JSONObject(builder.toString());

JSONArray listArray = topLevel.getJSONArray("list");
JSONObject firstObject = (JSONObject)listArray.get(0);
Double rain = firstObject.getDouble("rain");
System.out.println("TODAYs rain :" + rain);

     }