JSONObject jsono = new JSONObject();
jsono.put("last_name", "唐");
jsono.put("first-name", firstName);
String myjsonString = jsono.toString();

//write your output
DataOutputStream out = new DataOutputStream(new FileOutputStream("myjson.txt"));
out.write(myjsonString.getBytes("utf-8"),0, myjsonString.getBytes("UTF-8").length);