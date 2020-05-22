MbGlobalMap globalMap = MbGlobalMap.getGlobalMap("EXAMPLE.MAP");
HashMap<String,Object> map = (HashMap<String,Object>)globalMap.get("ALL");
Set<String> allKeys = map.keySet();
Iterator<String> iter = allKeys.iterator();

while(iter.hasNext()) {
    // Do something with map.get(iter.next());
}