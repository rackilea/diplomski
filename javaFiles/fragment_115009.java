public static int lowestTemperature(int[] temperatures) {
    int min = 999;
    for (int temperature : temperatures) {
        if (temperature > -999 && temperature < min) {
            min = temperature;
        }
    }
    return min;
}