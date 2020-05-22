public static int countIntegers(String input) {
    int count = 0;
    boolean isPreviousDigit = false;

    for (int i = 0; i < input.length(); i++) {
        if (Character.isDigit(input.charAt(i))) {
            if (!isPreviousDigit) {
                count++;
                isPreviousDigit = true;
            }
        } else {
            isPreviousDigit = false;
        }
    }
    return count;
}