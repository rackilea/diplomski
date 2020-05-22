Map<Long,List<String>> map = new HashMap<>();
...
if(map.get(key)!=null){
  List<String> list = map.get(key);
  list.add(value);
}else{
  List<String> list = new ArrayList<>();
  list.add(value);
  map.put(key,list);
}