//When i = 40, if i is greater than, or equal to 31, decriment until false
//When j = 120, if j is greater than, or equal to 30, decriment by 10 until false
for (double i = 40, j = 120; i >= 31 && j >= 30; i--, j -= 10) {
    c = i;
    f = j;
    //Show result
    System.out.println(c + "\t\t " + (Math.round(celsiusToFahrenheit(c) * 10.0) / 10.0) + "\t\t |\t" + f + "\t\t" + (Math.round(fahrenheitToCelsius(f) * 100.0) / 100.0));
}