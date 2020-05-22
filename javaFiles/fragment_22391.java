public static double[] getCityTemp(String city, int days)
{
    Scanner keyboard = new Scanner(System.in);
    double[] highs = new double[days];

    System.out.print("Enter " + days + " temperatures for " + city + ": ");

    for (int i = 0; i < days; i++) {
        highs[i] = keyboard.nextDouble();
    }

    return highs;
}