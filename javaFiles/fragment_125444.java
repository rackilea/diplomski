map3 = new HashMap<String, List<Incident>>();
map3.putAll(map1);
for(String key : map2.keySet()) {
    List<Incident> list2 = map2.get(key);
    List<Incident> list3 = map3.get(key);
    if(list3 != null) {
        list3.addAll(list2);
    } else {
        map3.put(key,list2);
    }
}