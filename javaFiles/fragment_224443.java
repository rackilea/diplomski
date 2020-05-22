public static void main(String[] args) {
  int[] numbers = {1, 1, 1, 2, 2, 2, 3, 3, 4, 4};
  int size      = 3;
  int minSum    = 4;

  search(numbers, size, minSum, 0, new LinkedList<Integer>());
}

private static void search(int[] numbers, int size, int minSum, int pos, Stack<Integer> stack) {
  if (stack.size() == size) {
    int sum = 0;
    for (int number : stack) {
      sum += number;
    }

    if (sum >= minSum) {
      System.out.println("Selection: " + stack);
    }

    return;
  }

  if (pos < numbers.length) {
    // Search by not adding the current number
    search(numbers, size, minSum, pos + 1, stack);
    // Search by adding the current number
    stack.push(numbers[pos]);
    search(numbers, size, minSum, pos + 1, stack);
    stack.pop();
  }
}