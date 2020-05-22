Map<Integer, Character> m = new HashMap<>();
      m.put(1, 'l');
      m.put(2, 'l');
      System.out.println(isOneToOne(m));


      public static boolean isOneToOne(Map<?, ?> map) {
         Set<?> set = new HashSet<>(map.values());
         return set.size() == map.keySet().size();
      }