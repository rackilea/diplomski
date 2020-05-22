List<int[]> listOfNumbers = new ArrayList<int[]>();
while(set.next()) {
     int[] numbers = new int[7];
     for (int i = 0; i < numbers.length; i++) {
         numbers[i] = set.getInt(i + 1);
     }
     listOfNumbers.add(numbers);
}