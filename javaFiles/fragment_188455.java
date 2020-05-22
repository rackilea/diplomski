public static HashMap<Integer,Integer> get(Integer key, HashMap<Integer, HashMap<Integer, Integer>> map){
    HashMap<Integer,Integer> innerMap = map.get(key);
    if(innerMap == null){
        innerMap = new HashMap<>();
        map.put(key, innerMap);
    }
    return innerMap;
}

    HashMap<Integer, HashMap<Integer, Integer>> outerMap = new HashMap<Integer, HashMap<Integer, Integer>>();

    HashMap<Integer, Integer> innnerMap = get(6, outerMap);
    innnerMap.put(5, 100);

    innnerMap = get(10, outerMap);
    innnerMap.put(5, 77);

    innnerMap = get(6, outerMap);
    innnerMap.put(33, 88);

    System.out.println(outerMap.get(6).get(5));