Map<String[], Boolean> hashMap = new HashMap<String[], Boolean>();
hashMap.put(new String[]{"bfa", "asdfs", "gr"}, true);
hashMap.put(new String[]{"efd", "asdfs", "gr"}, true);
hashMap.put(new String[]{"asd", "asdfs", "gr"}, true);
hashMap.put(new String[]{"bfd", "asdfs", "gr"}, true);

TreeMap<String[], Boolean> treeMap = new TreeMap<>(Comparator.comparing(a -> a[0]));
treeMap.putAll(hashMap);
treeMap.forEach((k, v) -> System.out.println(Arrays.toString(k) + " " + v));