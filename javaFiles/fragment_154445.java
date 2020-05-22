HashMap<Integer, Integer> count = new HashMap();
for(int i : arr){
   count.put(i, count.getOrDefault(count, 0) + 1);
}

int maxCount;
for(int i : count.values()){
   maxCount = Integer.max(maxCount, i);
}
return maxCount;