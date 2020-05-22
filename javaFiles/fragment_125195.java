JSONObject job = new JSONObject(json);
System.out.println("****job*******"+job);
String bodyofJson = job.getString("body");
System.out.println("****bodyofJson*******"+bodyofJson);
// Parse bodyofJson as JSONObject
JSONObject bodyJsonObj = new JSONObject(bodyofJson);
System.out.println(bodyJsonObj.get("ID"));