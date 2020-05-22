SortedMap<String, Integer> freq = new TreeMap<>(); // to sort keys alphabetically
for (String animal : animals) {
  if (animal.equals("---")) {
    System.out.println(freq);
    freq.clear();
  } else {
    freq.merge(animal, 1, Integer::sum);
  }
}
System.out.println(freq);