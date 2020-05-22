public static void method2() throws Exception {
    Random rng = new SecureRandom();
    Set<Integer> numbers = new HashSet<>();
    while (numbers.size() < 3) {
        // number only added if not already present in Set, set values are unique
        numbers.add(rng.nextInt(MAX));
    }
    List<Integer> numberList = new ArrayList<>(numbers);
    Collections.sort(numberList);
    // lower random at index 0, mid at index 1
    // you can guess where the other one is hiding 
    System.out.println(numberList);
}