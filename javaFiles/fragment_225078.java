Iterator it = map.entrySet().iterator();
while (it.hasNext()) {
    Map.Entry pairs = (Map.Entry)it.next();
    System.out.println("Key: " + pairs.getKey() + " Val: " + pairs.getValue()));
    it.remove(); // avoids a ConcurrentModificationException
}