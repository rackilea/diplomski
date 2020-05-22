JSONObject exchanges = ticker.getJSONArray("exchanges");
 for (Iterator i = exchanges.keys(); i.hasNext(); ) {
  String keys = (String) i.next();
  Util.logRanjith("Exchange name is " + keys);
  JSONObject temp = (JSONObject) jsonObject.get(keys);
  String last=temp.get("last").toString();
}