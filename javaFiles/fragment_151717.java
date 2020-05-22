final int MAX_PIES = 81;
final int MAX_PER_TYPE = 27;

String[] peanutArray = null;
String[] blueberryArray = null;
String[] appleArray = null;

String typeOfPie = getPieType();
while (!typeOfPie.equalsIgnoreCase("q")) {
    if (typeOfPie.equalsIgnoreCase("apple")) {
        appleArray = fillApple(typeOfPie, MAX_PER_TYPE);
    } else if (typeOfPie.equalsIgnoreCase("blueberry")) {
        blueberryArray = fillBlueberry(typeOfPie, MAX_PER_TYPE);
    } else if (typeOfPie.equalsIgnoreCase("peanut")) {
        peanutArray = fillPeanut(typeOfPie, MAX_PER_TYPE);
    }
    typeOfPie = getPieType();
}

if (typeOfPie.equalsIgnoreCase("q")) {
    int totalPies = calcTotalPies(appleArray, blueberryArray, peanutArray);
}