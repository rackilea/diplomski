while (!(fahrenheitInput.equals("-300"))) {

    fahrenheitInput = JOptionPane.showInputDialog(null,
            "Enter a number (in Fahrenheit) to convert to Celsius:");
    if("-300".equals(fahrenheitInput))
        break;

    double fahrenheit = Double.parseDouble(fahrenheitInput);

    celsiusCalculation = (fahrenheit - 32) * 5 / 9;

    celsiusCalculation = (int)(celsiusCalculation * 10);
    celsiusCalculation = celsiusCalculation / 10.0;

    JOptionPane.showMessageDialog(null, celsiusCalculation);
}