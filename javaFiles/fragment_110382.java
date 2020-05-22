List<JSONObject> yourList = new ArrayList<JSONObject>();
for(Object obj: sample) {
    JSONObject jsonObj = new JSONObject();
    jsonObj.put("q",(String)obj);
    yourList.add(jsonObj);
}