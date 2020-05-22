Map<String,String> map = new LinkedHashMap<String, Integer>();
// add some entries
List<Entry<String,Integer>> entryList =
    new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
Entry<String, Integer> lastEntry =
    entryList.get(entryList.size()-1);