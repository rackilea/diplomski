Map<Integer, Map<String,Integer>> mapOfMaps = new HashMap<Integer, Map<String,Integer>>();

for(Map<String,Integer> map : list){
    Integer id = map.get("id");
    Map<String,Integer> existingMap = mapOfMaps.get(id);
    if(existingMap == null){
        mapOfMaps.put(id, map);
    }else{
        existingMap.putAll(map);
    }
}