int[] numbers = new int[10];
for (int i = 0; i < 100; i++) {
    int ndx = (int) (Math.random() * numbers.length);
    numbers[ndx]++;
}
for (int i = 0; i < numbers.length; i++) {
    System.out.printf("%d was generated %d times.%n", i, numbers[i]);
}