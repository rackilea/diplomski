public static void main(String[] args) {
    Map<String, Double> map = new HashMap<>();
    map.put("AB", 0.5);
    map.put("AC", 0.7);
    map.put("AD", 0.2);
    map.put("B", 0.3);
    map.put("C", 0.9);

    Map<Character, Double> result =
        map.entrySet()
           .stream()
           .collect(Collectors.groupingBy(
             e -> e.getKey().charAt(0),
             Collectors.averagingDouble(Map.Entry::getValue)
           ));

    System.out.println(result); // prints "{A=0.4666666666666666, B=0.3, C=0.9}"
}