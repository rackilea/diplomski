public static void main(String[] args) {
  TemperatureC temp = new TemperatureC();
  double initialTemperature;
  Scanner keyboard = new Scanner(System.in);
  initialTemperature = keyboard.nextDouble();
  temp.setC(initialTemperature);

  System.out.println("The current temperature in Celsius is: " + temp.getC());
  System.out.println("The current temperature in Fahrenheit is: "+temp.getF());
  System.out.println("The current temperature in Kelvin is: "+temp.getK());
}