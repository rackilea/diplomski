Object value = map.get(new Integer(2));
if (map.containsKey(new Integer(2))) {
    System.gc(); // can happen here
    System.out.println(value);
} else {
    System.out.println("Key is deleted");
}