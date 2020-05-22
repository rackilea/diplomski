// Autoboxing will turn "1", "2", "3" into Integers from ints.
List<Integer> numbers = Arrays.asList(1, 2, 3); 

int sum = 0;

// Integers from the "numbers" List is unboxed into ints.
for (int number : numbers) {
  sum += number;
}