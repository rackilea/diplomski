public static double average(double[] array) {

    if(array.length == 0) {
        return 0;
    }

    double sum = 0;

    for (int i = 0; i < array.length; i++) {
        sum += array[i];
    }

    double average = sum / array.length;
    return average;
}