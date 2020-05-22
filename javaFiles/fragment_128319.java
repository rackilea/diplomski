// Build the source JSONArray
JSONArray array = new JSONArray();
array.put(
    new JSONObject("{\"2016-11-09 19:01:59.649\":\"someone@email.com::example message\"}")
);
array.put(
    new JSONObject("{\"2016-11-09 19:01:05.542\":\"someone@email.com::another example\"}")
);
array.put(
    new JSONObject("{\"2016-11-09 19:02:01.394\":\"someother@gmail.com::another one\"}")
);

// Extract the JSONObjects
JSONObject[] objects = new JSONObject[array.length()];
for (int i = 0; i < objects.length; i++) {
    objects[i] = array.getJSONObject(i);
}
// Sort the array of JSONObjects
Arrays.sort(
    objects,
    (JSONObject o1, JSONObject o2) ->
        ((String)o1.keys().next()).compareTo((String)o2.keys().next())
);
// Build a new JSONArray from the sorted array
JSONArray array2 = new JSONArray();
for (JSONObject o : objects) {
    array2.put(o);
}
System.out.println(array2);