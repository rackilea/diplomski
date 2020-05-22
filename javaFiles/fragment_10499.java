do {
    i = 0;  // It won't work without this
    do {
        Random rand = new Random();
        int mout = rand.nextInt(max - 0);
        System.out.print(mout + " ");
        i++;
    } while (i < matrixn);
    System.out.println();
    j++;
} while (j < matrixn);