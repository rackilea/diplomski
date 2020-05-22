JSONArray array = new JSONArray();
array.put("10.254.27.12");
array.put("10.254.27.123");

JSONObject inputJsonObj = new JSONObject();
inputJsonObj.put("ipaddresses",array);
// Using ipaddresses as there are many addresses
// The rest of the code stays the same