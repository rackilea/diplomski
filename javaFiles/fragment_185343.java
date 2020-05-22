Random rand = new Random();
int[] array = new int[randomNumbers];
for (int i = 0; i < array.length; i++) {
  array[i] = lower + rand.nextInt(range);
}
printArray(array);