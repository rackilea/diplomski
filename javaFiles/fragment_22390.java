public static void main(String[]args)
{
    String[] cities = {
        "Miami", "Dallas"
    };

    for (String city : cities) {
        double[] highs = getCityTemp(city, 5);
        printCityTemp(city, highs);
    }
}