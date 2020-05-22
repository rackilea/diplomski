JSONArray obj = new JSONArray();
JSONObject jsonobj=new JSONObject();

HashMap rows=new HashMap();
rows.put("tableno","123");
rows.put("status","active");
rows.put("section","pub");
rows.put("custid","12");
obj.put(rows);

jsonobj.put("hoteltables", obj);

obj = new JSONArray();

rows=new HashMap();
rows.put("itemid","12");
rows.put("item","ABC");
rows.put("status","available");
rows.put("section","pub");
rows.put("imagename","XYZ");
obj.put(rows);

jsonobj.put("mainiteam", obj);

obj = new JSONArray();
rows=new HashMap();
rows.put("baseitem","148");
rows.put("item","HIJ");
rows.put("rate","123");
rows.put("section","pub");
rows.put("imagename","pic.png");
obj.put(rows);

jsonobj.put("subitem", obj);

System.out.println(jsonobj.toString());