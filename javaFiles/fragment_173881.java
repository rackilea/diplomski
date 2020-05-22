public static int romanNumeralToInt(String romanNumeral) {
    int intNumeral = 0;
    switch (romanNumeral) {
    case "I":
        intNumeral = 1;
        break;
    case "V":
        intNumeral = 5;
        break;
    case "X":
        intNumeral = 10;
        break;
    case "L":
        intNumeral = 50;
        break;
    case "C":
        intNumeral = 100;
        break;
    case "D":
        intNumeral = 500;
        break;
    case "M":
        intNumeral = 1000;
        break;
    }
    return intNumeral;
}