public void addToMap(HashMap<Integer, List<Integer>> map, Integer key, Integer value){
  if(!map.containsKey(key)){
    map.put(key, new ArrayList<>());
  }
  map.get(key).add(value);
}