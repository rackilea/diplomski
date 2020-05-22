final Map<String, Integer> map = new HashMap<>();
map.put("test", 1);
map.put("test1", 3);
map.put("test3", 4);
map.put("test2", 75);
map.put("a", 75);
map.put("test100", 100);

final List<String> test = map
        .entrySet()
        .stream()
        .sorted((Entry<String, Integer> o1, Entry<String, Integer> o2) -> {
              return o1.getValue().equals(o2.getValue()) ? 
                          o1.getKey().compareTo(o2.getKey()) 
                              : o1.getValue().compareTo(o2.getValue());
          })
        .map(e -> e.getKey())
        .collect(Collectors.toList());

for(String s : test)
      System.out.println(s);