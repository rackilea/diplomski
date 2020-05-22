List<Integer> evenNumbers = new ArrayList<>();
List<Integer> oddNumbers = new ArrayList<>();

for (i = 0; i < numbers.length; ++i) {
  if (numbers[i] % 2 == 0) {
    evenNumbers.add(numbers[i]);
  }
  else {
     oddNumbers.add(numbers[i]);
  }
}