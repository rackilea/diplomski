for (double i = 40; i >= 31; i--) {
    c = i;

    //When j = 120, if j is greater than, or equal to 30, decriment by 10 until false
    for (double j = 120; j >= 30; j -= 10) {
        f = j;

        //Show result
        System.out.println(c + "\t\t " + (Math.round(celsiusToFahrenheit(c) * 10.0) / 10.0) + "\t\t |\t" + f + "\t\t" + (Math.round(fahrenheitToCelsius(f) * 100.0) / 100.0));

    }
}