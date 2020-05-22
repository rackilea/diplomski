public static String getAdd(int numerator1, int numerator2, int denominator1, int denominator2) {

    int numer = (numerator1 * denominator2) + (denominator1 * numerator2);
    int deno = (denominator1 * denominator2);

    return numer + "/" + deno;
}