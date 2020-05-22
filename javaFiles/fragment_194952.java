hmap = new HashMap<String, List<String>>();

List<String> list;
for (String set : splitSet) {  
    key = splitSet[0];
    value1 = splitSet[1];
    value2 = splitSet[2];
    list = new ArrayList<String>();
    hmap.put(key, list);
    list.add(value1);
    list.add(value2);
}