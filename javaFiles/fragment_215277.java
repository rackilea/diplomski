final int rowWidth = 10;
final int colHeight = 10;
final double[] possibleValues = {0.0, 0.5, 1.0, 2.0 ,5.0};

Random rand = new Random();

double[][] board = new double[rowWidth][colHeight];

for (double[] board1 : board) {
    for (int col = 0; col < board1.length; col++) {
        board1[col] = possibleValues[rand.nextInt(possibleValues.length)];
    }
}