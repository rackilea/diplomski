TreeSet<Integer> set = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>() {{ 
    put(1, 1); put(2, 2); put(3, 3);
}};

set.removeAll(map.entrySet().stream()
    .filter(x -> x.getValue() > 1)
    .map(Map.Entry::getValue)
    .collect(Collectors.toList()));

System.out.println(set); // prints [1, 4, 5, 6, 7]