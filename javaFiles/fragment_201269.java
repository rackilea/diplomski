Map<String,Collection<Integer>> map = new HashMap<String, Collection<Integer>>();
addToMapOfCollections(map,"String1",5,HashSet::new);
addToMapOfCollections(map,"String2",67,ArrayList::new);
addToMapOfCollections(map,"String2",68,ArrayList::new);
System.out.println (map);
for (Collection<Integer> col : map.values ()) {
    System.out.println (col.getClass () + " : " + col);
}