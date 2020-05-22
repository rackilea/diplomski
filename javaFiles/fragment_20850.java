int array[] = {1,2,3,3,4,5,6,6,7,8,8,10,10,11,12,13};

//Count occurrences of each number
Map<Integer, Integer> map = new HashMap<>();
Arrays.stream(array).forEach(value -> {
  Integer occurrences = map.get(value);
  map.put(value, occurrences == null ? 1 : occurrences +1);
});

//Display number of occurrences when nbOccurrences > 1
map.entrySet()
    .stream()
    .filter(entry -> entry.getValue() > 1)
    .forEach(entry -> System.out.println(entry.getKey() + " : "+entry.getValue()));