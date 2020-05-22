int primeNumbersToBeFound = 33;

    int rows = (int) Math.ceil(Math.sqrt(primeNumbersToBeFound));
    int cols = rows;
    if (rows * (rows - 1) >= primeNumbersToBeFound) {
        cols--;
    }

    System.out.println(primeNumbersToBeFound + " = [" + rows + "," + cols + "]");