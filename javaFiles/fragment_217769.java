//If still using Java 6 enter the generic types in the diamond
Map<Integer, List<Character>> treeMap = new TreeMap<>(); 
for(Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
    Integer value = entry.getValue();
    if(treeMap.get(value) == null) {
        treeMap.put(value, new ArrayList<Character>());
    }

    List<Character> arrayList = treeMap.get(value);
    arrayList.add(entry.getKey());

    //You can convert the above into this if you want, as well:
    //   treeMap.get(value).add(entry.getKey());
}