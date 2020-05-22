// Generate a random array of numbers
Random r = new Random();
Integer[] numbers = new Integer[r.nextInt(100) + 20];
for (int i = 0; i < numbers.length; i++) {
    numbers[i] = r.nextInt(50000) + 100;
}
// Order the array and print it
Arrays.sort(numbers);
System.out.println(Arrays.toString(numbers));
// Find the index of the amount limit (10000 in this case)
int index = Arrays.binarySearch(numbers, 10000);
// Print the slice of array that is lower than the limit amount
System.out.println(Arrays.toString(Arrays.copyOfRange(numbers, 0, Math.abs(index) + 1)));