HashMap<Integer, HashMap<Integer, Integer>> outerMap = new HashMap<>();
HashMap<Integer, Integer> innerMap = null;

innerMap = outerMap.computeIfAbsent(6, HashMap::new); // this will put a new inner HashMap 
                                                      // in the outer HashMap if it
                                                      // doesn't contain a value for the
                                                      // given key 6, or return the
                                                      // existing inner map otherwise
innerMap.put(5, 100);

innerMap = outerMap.computeIfAbsent(10, HashMap::new);
innerMap.put(5, 77);

innerMap = outerMap.computeIfAbsent(6, HashMap::new);
innerMap.put(33, 88);

System.out.println(outerMap.get(6).get(5));