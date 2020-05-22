Integer a[] = { 10, 20, 30, 10, 10, 20, 50, 60, 50, 50 };
Set<Integer> noDuplicateInt = new HashSet<>();
Map<Integer, Integer> numOccurenceMap = new HashMap<>();
for (Integer integer : a) {
    if (noDuplicateInt.add(integer)) {
        numOccurenceMap.put(integer, 1);
    } else {
        numOccurenceMap.replace(integer, numOccurenceMap.get(integer) + 1);
    }
}
System.out.println(numOccurenceMap);