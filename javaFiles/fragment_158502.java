List<X> xs = ...
Map<Integer, Set<X>> mapBySortVal = new LinkedHashMap<>();
for(X x: xs) {
   Set<X> set = mapBySortVal.get(x.sortVal);
   if (set == null)
      mapBySortVal.put(x.sortVal, set = new LinkedHashSet<>());
   set.add(x);
}

for(Integer value: myValues) {
   Set<X> xs = mapBySortVal.get(value);
   if (xs != null) 
       // found some.
}