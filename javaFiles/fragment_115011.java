public static double averageTemperatureOneLiner(int[] temperatures) {
    return Arrays.stream(temperatures).filter(t -> t > -999 && t < 999).average().orElse(0);
}


public static int lowestTemperatureOneLiner(int[] temperatures) {
    return Arrays.stream(temperatures).filter(t -> t > -999 && t < 999).min().orElse(0);
}


public static int highestTemperatureOneLiner(int[] temperatures) {
    return Arrays.stream(temperatures).filter(t -> t > -999 && t < 999).max().orElse(0);
}