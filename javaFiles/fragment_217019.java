List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(5, 1, 3, 6, 4));
 List<String> letters = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e"));
 Map<Integer, String> map = new HashMap<Integer, String>();
 for (int i = 0, n = numbers.size(); i < n; i++) {
     map.put(numbers.get(i), letters.get(i));
 }
 Collections.sort(numbers);
 letters.clear();
 for (int number : numbers) {
     letters.add(map.get(number));
 }
 System.out.println(numbers);
 System.out.println(letters);