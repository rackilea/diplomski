double[][] data = {{1.1, 1.2}, {2.1, 2.2}, {3.1, 3.2}};
Random random = new Random();
int numberOfValues = data.length * data[0].length;
for (int i = numberOfValues - 1; i > 0; i--) {
    int index = random.nextInt(i);
    int row = i / data[0].length;
    int column = i - row * data[0].length;
    int randomRow = index / data[0].length;
    int randomColumn = index - randomRow * data[0].length;
    double temp = data[row][column];
    data[row][column] = data[randomRow][randomColumn];
    data[randomRow][randomColumn] = temp;
}
System.out.println("toArray = " + Arrays.deepToString(data));