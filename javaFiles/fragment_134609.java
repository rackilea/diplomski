JSONArray inner = new JSONArray()
inner.add(1);inner.add("text");
JSONObject outer = new JSONObject();
outer.put("data",inner);
outer.put("label", "stuff");

String out = outer.toString()