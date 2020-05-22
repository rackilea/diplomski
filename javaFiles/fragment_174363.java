public void injectArrayIntoHashMap() {
      HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
      ArrayList<String> l1 = new ArrayList<String>();
      l1.add("hello");
      l1.add("howdy");
      map.put("hi", l1);

      HashMap<String, ArrayList<String>> newMap = new HashMap<String, ArrayList<String>>();
      ArrayList<String> l2 = new ArrayList<String>();
      l2.add("hello");
      l2.add("howdy");
      newMap.put("hi", l2);

      System.out.println(map.equals(newMap));
}