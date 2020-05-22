JSONObject myobject = new JSONObject("{ your json goes here"});
JSONObject order = myobject.getJSONObject("order");

List<Long> result = new ArrayList<Long>();
for (int i=0; i<order.getJSONArray("approved").length(); i++) {
    Long value = order.getJSONArray("approved").getLong(i);
    result.add(value);
}
...