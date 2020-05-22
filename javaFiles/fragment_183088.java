Integer maxValue=0;
for (Map.Entry<Integer, Integer> entry : countMap.entrySet()){
  if(entry.getValue => maxValue){
    maxValue = entry.getValue;
    maxResultList.add(entry.Key);
  }
}