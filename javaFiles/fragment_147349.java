Map<Integer, Integer> countMap = new LinkedHashMap<>();
Integer v = sortedNum.isEmpty()? null: sortedNum.get(0);
int count = 0;
for(Integer i: sortedNum) {
    if(v + count == i) count++;
    else {
        countMap.put(v, count);
        v = i;
        count = 1;
    }
}
if(v != null) countMap.put(v, count);