public static void printCityTemp(String city, double[] highs)
{
    System.out.print("Highs for " + city + " were: ");

    for (double high : highs) {
        System.out.print(high + " ");
    }

    System.out.println("");
    return;
}