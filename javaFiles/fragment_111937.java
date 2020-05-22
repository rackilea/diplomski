Gson gson = new Gson();
Type type = new TypeToken<Map<String, ArrayList<Map<String, Object>>>>() {}.getType();
Map<String, ArrayList<Map<String, Object>>> data = gson.fromJson(reader, type);
Map<String, Object> map = data.get("entries").get(0);
System.out.println(map.get("pageref"));  // page_0
System.out.println(map.get("time"));     // 515.0