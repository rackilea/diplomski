public static String parseToCientificNotation(double result) {
    int cont = 0;
    java.text.DecimalFormat DECIMAL_FORMATER = new java.text.DecimalFormat("0.##");
    while (((int) result) != 0) {
        result/= 10;
        cont++;
    }
    return DECIMAL_FORMATER.format(result).replace(",", ".") + " x10^ -" + cont;