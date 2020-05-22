public static int partition(int[] input, int first, int end) {
    int pivot = input[(first + end)/2];
    int i = first;
    int j = end;

    while (true) {

      while (input[i] < pivot) {
        i++;
      }

      while (input[j] > pivot) {
        j--;
      }

      if (i < j)
        swap(input, i, j);
      else
        return j;
    }
}