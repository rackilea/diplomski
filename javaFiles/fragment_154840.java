void findSmallestNumberIndex(int[] numbers, int index) {

  //int[] numbers = {4, 9, 2, 10, 5, 3, 6, 1, 8, 7};

  int n = numbers.length;
  int min_idx = index; //4

  for (int j = index + 1; j < n; j++) {
   if (numbers[j] < numbers[min_idx]) {
    min_idx = j;
   }

  }
  int temp = numbers[min_idx];
  numbers[min_idx] = numbers[index];
  numbers[index] = temp;
 }