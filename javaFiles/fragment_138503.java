List<List<String>> list = new ArrayList<>();
list.add(Arrays.asList("Test", "Test 1", "Test 2"));
list.add(Arrays.asList("Apple", "Sandwich", "Banana"));
list.add(Arrays.asList("Cake", "Ice Cream", "Fruit"));

// list.forEach(t -> showAllPermuteByCommons(t));
list.forEach(t -> showAllPermute(t));