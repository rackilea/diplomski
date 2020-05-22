JSONObject parent = (JSONObject) lev1.get("parent");
JSONArray child1 = (JSONArray) parent.get("child1"); // same for child2
for (Object elem : child1) {
    System.out.prinlnt("date =  " + ((JSONObject) elem).get("date"));
    System.out.prinlnt("time =  " + ((JSONObject) elem).get("time"));
}