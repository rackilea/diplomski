HashMap<String, Integer> compareSet = new HashMapt<String, Integer> ();
...
Integer act = compareSet.get(groupInteger);
if (act != null) {
    System.out.println("duplicate found ");
    compareSet.put(groupInteger, act + 1);
} else {
    compareSet.put(groupInteger, 1);
}