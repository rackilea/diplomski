Map<String, Integer> treeMap = new TreeMap<String, Integer>(map);

    for(Map.Entry<String, Integer> entry: treeMap.entrySet()) {
        System.out.println(entry.getKey() + " : " + entry.getValue());

    }