public double[][] shuffleBoard(double[][] currentBoard) {
    double[][] shuffledBoard = currentBoard;
    Random rand = new Random();
    double rangeMin = 1, rangeMax = 5;
    for (int i = 0; i < 5; i++) {
        double j = rangeMin + (rangeMax - rangeMin) * rand.nextDouble();
        shuffledBoard[i][0] = j;
    }
    return shuffledBoard;
}