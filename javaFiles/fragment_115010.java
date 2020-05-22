public static double averageTemperature(int[] temperatures) {
    int sum = 0, validTemperatureCounter = 0;
    for (int temperature : temperatures) {
        if (temperature > -999 && temperature < 999) {
            validTemperatureCounter++;
            sum += temperature;
        }
    }
    return sum / (double)validTemperatureCounter;
}