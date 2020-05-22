public static boolean areEqualByThreeDecimalPlaces(double firstValue, double secondValue) {
    // Math.pow(...) retuns a double so it have to downcast to int
    int moveThreeDecimalPlacesToRight = (int) Math.pow(10, 3);
    /* 
     * We don't care about just the first three decimal places
     * If fisrtValue is 123.456789 then 
     * firstValue * moveThreeDecimalPlacesToRight will be 123456.789
     * and secondValue * moveThreeDecimalPlacesToRight will be 123456.999
     * so both of them must be downcasted to int 
     * because 123456.789 will never be equal to 123456.999
    */
    return (int) (firstValue * moveThreeDecimalPlacesToRight) == (int) (secondValue * moveThreeDecimalPlacesToRight);
}