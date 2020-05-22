public static String convert(int number) {
    if (number < 0 || number > 3999) {
        return "This number cannot be converted";
    }

    String romanOnes = romanDigit(number % 10, "I", "V", "X");
    number /= 10;

    String romanTens = romanDigit(number % 10, "X", "L", "C");
    number /= 10;

    String romanHundreds = romanDigit(number % 10, "C", "D", "M");
    number /= 10;

    String romanThousands = romanDigit(number % 10, "M", "", "");
    number /= 10;

    String result = romanThousands + romanHundreds + romanTens + romanOnes;
    return result;
}