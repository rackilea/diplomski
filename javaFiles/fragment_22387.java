public static double[] getHighTemperatures(String cityName, int numberOfDays)
{
    Scanner keyboard = new Scanner(System.in);
    double[] highsForNewYork = getHighTemperatures("New York", 5);
    for (int i = 0; i < numberOfDays; i++)
        highsForNewYork[i] = keyboard.nextDouble();
    return (highsForNewYork);
}