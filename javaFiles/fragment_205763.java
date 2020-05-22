HashSet<HashSet<String>> filter=new HashSet<>();
for(List<String> list: lists){
  HashSet<String> key=new HashSet<>(list);
  if(!filter.contains(key)){
    filter.add(key);
    filtered.add(list);
  } else {
    duplicates.add(list);
  }
}