List<String> stuff = new ArrayList<String>();
// ...populate it

Map<String, Integer> map = new HashMap<String, Integer>();    
for(String string : stuff) {
    if(map.containsKey(string)) {
        map.put(string, map.get(string) + 1);
    }
    else {
        map.put(string, 1);
    }
}