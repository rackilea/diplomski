Multimap<String, String> map = LinkedHashMultimap.create();
// write data to map
for(String word: yourData){
    map.put(mapKey(word), word);
}
// read items from map, grouped by prefix
for (String value : map.values()) {
    System.out.println(value);
}