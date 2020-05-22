public static double[] randomArray(int n) {
    double[] randomArray = new double[n];
    Random randNumGenerator = new Random();
    for (int i = 0; i < n; i++) {
        randomArray[i] = randNumGenerator.nextDouble() * 256;
    }
    return randomArray;
}