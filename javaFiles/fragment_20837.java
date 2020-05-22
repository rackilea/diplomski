JSONArray ac=new JSONArray();
JSONObject acontent=new JSONObject();  

acontent.put("x", "0");
acontent.put("y",a);
ac.add(acontent);
acontent = new JSONObject();

acontent.put("x", "1");
acontent.put("y",b);
ac.add(acontent);

acontent = new JSONObject();
acontent.put("x", "2");
acontent.put("y",c);

ac.add(acontent);