HashMap<Integer, String> map = new HashMap<>();
map.put(1, "One");
map.put(2, "Two");
map.put(3, "Three");

// Output is "{1=One, 2=Two, 3=Three}"
System.out.println(map);

Collection<String> backedUpCollection = map.values();

// Remove something from collection and check the maps content
backedUpCollection.remove("Two");

// Output is "{1=One, 3=Three}"; "Two" was removed
System.out.println(map);

// Add an entry to the map and check the content of collection
map.put(4, "Four");

// Output is "[One, Three, Four]"; "Four" was added
System.out.println(backedUpCollection);