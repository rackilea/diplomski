for (int i = 0; i < 10; i++ ) {
    double celcius = 40 - i;
    double convertedCelcius = celciusToFahrenheit(celcius);
    double fahrenheit = 120 - (i * 10);
    double convertedFahrenheit = fahrenheitToCelcius(fahrenheit);

    System.out.print(celcius + "\t" + convertedCelcius + "\t|\t" + fahrenheit + "\t" + convertedFahrenheit + "\n");
}