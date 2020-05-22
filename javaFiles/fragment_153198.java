public static void main(String[] args) {
    double[] data = {0.2554, 4.4464, 0.3897, 4.2112};
    double checkVal, currentVal;
    int countEq, countSup;

    //use for loop to iterate through the arrays
    for (int i = 0; i < data.length; i++) {
        countEq = countSup = 0;
        currentVal = data[i];
        for (int j = 0; j <= i; j++) {
            checkVal = data[j];
            if (currentVal == checkVal) {
                countEq++;
            } else if (checkVal > currentVal) {
                countSup++;
            }
        }
        double fand = (countSup + 0.5 * countEq) / (i + 1);
        System.out.println(currentVal + " " + fand);
    }
}