List<Integer> numbers = new ArrayList<Integer>();
numbers.add(1);
numbers.add(2);
numbers.add(3);
numbers.add(4);

// Scenario 1:
numbers.remove(2);

// Scenario 2:
numbers.remove((Integer)3);

System.out.println(numbers);