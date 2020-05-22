private static int[][] makeArray(int columns, int rows) {
  int totalItems = rows * columns;

  if (totalItems % 2 != 0) {
    throw new IllegalArgumentException("Must be an even number of cells.");
  }

  List<Integer> numbers = new ArrayList<>();
  for (int i = 0; i < totalItems / 2; i++) {
    numbers.add(i);
    numbers.add(i);
  }

  Collections.shuffle(numbers);
  Iterator<Integer> iterator = numbers.iterator();

  int[][] result = new int[columns][rows];

  for (int x = 0; x < columns; x++) {
    for (int y = 0; y < rows; y++) {
      result[x][y] = iterator.next();
    }
  }

  return result;
}