JSONArray a1 = new JSONArray("[[1375056000000,23.284713745117],[1375142400000,3.809531211853]]");
for (int i=0; i<a1.length(); i++) {
 JSONArray a2 = a1.getJSONArray(i);
 long v1 = a2.getLong(0);
 double v2 = a2.getDouble(1); 
}