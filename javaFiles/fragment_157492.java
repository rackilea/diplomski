int[] values = new int[]{10, 9, 8, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

final int key = 15;
int index = 0;
while (true) {
  int value = values[index];
  if (value == key) {
    System.out.println("Key found at index " + index);
    break;
  }

  index = Math.abs(key - value) + index;
  if (index >= values.length) {
    System.out.println("Key not found");
  }
}