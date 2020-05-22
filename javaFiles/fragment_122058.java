public class TemperatureConverter {

  public static double celsiusToFahrenheit(double celsius) {
    return 9.0 / 5 * celsius + 32;
  }

  public static double fahrenheitToCelsius(double fahrenheit) {
    return 5.0 / 9 * (fahrenheit - 32));
  }

  public static void main(String[] args) {
    double celsius = 40;
    double fahrenheit = 120.0;
    System.out.println("Celsius   Fahrenheit\t|  Fahrenheit   Celsius   ");
    while (celsius > 30) {
      System.out.printf("%-10.1f%6.2f\t|%8.2f%12.2f\n", celsius, 
          celsiusToFahrenheit(celsius), fahrenheit, fahrenheitToCelsius(fahrenheit));
      celsius--;
      fahrenheit -= 10;
    }
  }
}