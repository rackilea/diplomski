if (arrOne != null) {
    JSONObject entryCountJson;
    String entry, count;
    for (Object o : arrOne) {
        entryCountJson = (JSONObject) o;
        entry = String.valueOf(entryCountJson.get("entry"));
        count = String.valueOf(entryCountJson.get("count"));
        listOne.add("(" + entry + "," + count + ")");
    }
}
System.out.println("arrOne: "+arrOne);
System.out.println("listOne: "+listOne);