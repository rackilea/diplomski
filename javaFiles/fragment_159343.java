Map<Integer, Optional<String>> map = new HashMap<>(); 

//Optional.ofNullable - allows passed parameter to be null.
map.put(1, Optional.ofNullable("one")); 
map.put(2, Optional.ofNullable("two")); 
map.put(3, Optional.ofNullable(null)); 
map.put(4, Optional.ofNullable("four")); 

Map<Integer, Optional<String>> map2 = map.entrySet().stream()
        .filter(e -> e.getKey() > 2)
        .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

System.out.println(map2.toString());