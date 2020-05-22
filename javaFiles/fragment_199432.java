Set<Long> set = myMap.get(1);
if (set == null) {
    set = new HashSet<Long>(); // or whatever Set implementation you use
    myMap.put(1, set);
}
set.add(myLong);