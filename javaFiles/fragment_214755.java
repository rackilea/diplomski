//Assumes that day and hour counting start at 0
    public static double getTemperature (double[][] temps, int day, int hour) {
        return temps[day][hour];
    }

//Assumes that day and hour counting start at 1
    public static double getTemperature (double[][] temps, int day, int hour) {
        return temps[day-1][hour-1];
    }