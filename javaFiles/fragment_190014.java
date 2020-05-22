public static void main(String [] args) throws Exception {

    System.out.println(convertFromDecimal(15,3));
}

public static String convertFromDecimal(int number, int base) {
    String result = "";

    int lastQuotient = 0;

    for(int operatingNumber = number;operatingNumber > base; operatingNumber = operatingNumber/base) {
        result = getRepresantationOfLowIntValue(operatingNumber%base) + result;
        lastQuotient = operatingNumber/base;
    }

    result = getRepresantationOfLowIntValue(lastQuotient) + result;

    return result;
}