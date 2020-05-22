List<String> global = new ArrayList<String>;
    Map<String,  ArrayList<String>> newMap = new HashMap<String, ArrayList<String>>();
    Map<String,  ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    for (String key:map.keySet()) {
        List<String> arrayList= map.get(key);
        for (String words:arrayList) {
            List<String> newList = new ArrayList<String>;
            for (String globallist:global) {
                if(words.equals(globallist)){
                    newList.add(words);
                }
            }
            newMap.put(key,newList);
        }
    }