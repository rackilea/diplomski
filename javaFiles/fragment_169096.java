Collection<String> c1 = map1.values();
c1.removeAll(map2.values());  // this one removes all the values from c1 which are also in map2.
Iterator<String> it = c1.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}