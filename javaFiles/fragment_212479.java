final HashMap<String, Integer> map = new HashMap<>();

map.put("it", 2);
map.put("of", 2);
map.put("the", 2);
map.put("times", 2);
map.put("was", 2);
map.put("best", 1);
map.put("worst", 1);

System.out.println("No Guaranteed Order:");
map.entrySet().stream()
        .forEach(System.out::println);


System.out.println();
System.out.println("With Ordering:");
map.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                .thenComparing(Map.Entry.comparingByKey()))
        .forEach(System.out::println);