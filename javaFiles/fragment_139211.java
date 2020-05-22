// call this method
public static int removeLastDigit(int number) {
    return removeLastDigitImpl(number, largestDigit(number));
}

private static int removeLastDigitImpl(int number, int largestDigit) {
    if (number < 10) { // if the number is a single digit, decide what to do with it
        if (number == largestDigit) {
            return 0; // if it is the largest digit, remove it
        } else {
            return number; // if it is not, keep it
        }
    }
    // handle the last digit of the number otherwise
    if (number % 10 == largestDigit) {
        // removing the digit
        return removeLastDigitImpl(number / 10, largestDigit);
    } else {
        // not removing the digit
        return removeLastDigitImpl(number / 10, largestDigit) * 10 + number % 10;
    }
}

// this is the same as your attempt
private static int largestDigit(int n){

    if(n==0)
        return 0;
    return Math.max(n%10, largestDigit(n/10));

}