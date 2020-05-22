// Dummy value to associate with an Object in the backing Map
private static final Object PRESENT = new Object();
...

 public boolean add(E e) {
    return map.put(e, PRESENT)==null;
}