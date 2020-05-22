void callingMethod() {
   HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
   map.put(1, 2);

   badMethod(map);

   // NullPointerException
   System.out.println(map.get(1).intValue());
}

void badMethod(final HashMap<Integer, Integer> map) {
   map.clear();
}