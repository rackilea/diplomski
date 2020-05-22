Map<String,String> mss=new HashMap<String,String>();
mss.put("France", "Paris");
mss.put("Germany", "Berlin");

JSONObject j=new JSONObject(mss);

System.out.println(j);