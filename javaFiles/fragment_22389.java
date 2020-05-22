public static double[] getCityTemp(double[]temp, String ... cities)
{
    Scanner keyboard = new Scanner(System.in);
    if (cities.length == 0) {
        System.out.println("No argument passed.");
        return;
    }
    String cityA = cities[0];

    for (int i = 0; i < temp.length; i++) {
        System.out.print("Enter 5 temperatures for City A. ");
        temp[i] = keyboard.nextDouble();
        if (i < cities.length) {
            cityA = cities[i];
        }
    }
    /* ... */
}