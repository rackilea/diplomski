public static void main(String[] args) {

Multimap<Integer, String> multiMap = HashMultimap.create();
multiMap.put(0, "key0_value0");
// Twice the same value for the same key, the Set<String> will "ignore" this
multiMap.put(0, "key0_value0"); 
multiMap.put(1, "key1_value0"); 
multiMap.put(1, "key1_value1"); 


System.out.println("Values for key 0");
System.out.println("----------------");
System.out.println(multiMap.get(0));
System.out.println("\r\nValues for key 1");
System.out.println("----------------");
System.out.println(multiMap.get(1));
System.out.println("\r\nAll values");
System.out.println("------------");
System.out.println(multiMap.values());

// Entries are all Integer/String associations
Collection<Entry<Integer, String>> entries = multiMap.entries();
System.out.println("\r\nNumber of entries : " + entries.size());

// We can build a standard Java Map out of the Multimap
Map<Integer, Collection<String>> realJavaMap = multiMap.asMap();
// The map's values are actually guaranteed to be Sets
System.out.println("Multimap as Map, values implement Set : " + Set.class.isAssignableFrom(realJavaMap.values().iterator().next().getClass()));

// The java Map is a live view of the multimap
realJavaMap.get(0).add("key0_value1"); // Actions on realJavaMap will update multimap

System.out.println("\r\nValues for key 0");
System.out.println("----------------");
System.out.println(multiMap.get(0));