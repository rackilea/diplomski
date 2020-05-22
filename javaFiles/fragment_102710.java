// Initialization.
Map<Integer,String> map = new HashMap<Integer,String>();
map.put(1,"TEST");
map.put(2,"HELLO");

// Printing.
String s = map.get(USER_INPUT);
if (s == null)
    System.out.println("Key doesn't exist.");
System.out.println(s);