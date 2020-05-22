//1) Setup the mapping, 
//The first parameter to put() is the key (perhaps a user given name?) 
//and the second parameter is actual value you want to map for that key.
//note that although I'm using a String as the key and a String as the value
//You can use pretty much any object as the value. Keys are recommended to be
//immutable objects (a String is a good one)
Map<String,String> mMap = new HashMap<String,String>();
mMap.put("John", "Orange");
mMap.put("Steve","Apple");

//2) Once the map is setup, you can then retrieve values given a key:
System.out.println("John's fruit is: "+mMap.get("John"));