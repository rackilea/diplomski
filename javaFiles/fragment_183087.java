for(Integer value:myMap.values() ){
  Integer count = 1;
  if(countMap.contains(value)){
    count = countMap.get(value);
    count++;
  }

  countMap.put(value, count);
}