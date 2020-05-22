Map<List<Integer>,String> map =
    new HashMap<List<Integer>,String>();
List<Integer> theOneKey = new ArrayList<Integer>();
map.put(theOneKey, "theOneValue");

System.out.println(map.containsKey(theOneKey)); // prints "true"
theOneKey.add(42);
System.out.println(map.containsKey(theOneKey)); // prints "false"