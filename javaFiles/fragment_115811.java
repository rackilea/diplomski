public String add(String a, String b) {
    // I assume the strings are equal of length. If they are not, they
    // should be padded with zeroes. Otherwise, you can check if one string
    // has been 'exhaused', avoiding an IndexOutOfBoundsException.

    // The carry is the number which is 'dragged' to the next two integers
    // when it is greater than 9. While adding no more than two numbers, the
    // carry will always be 0 or 1.
    int carry = 0;
    // Our result as a string.
    String result = "";

    // Start at the right-most part the string, because that is
    // the least significant number.
    for (int i = a.length() - 1; i >= 0; i--) {
        // A string is an array of characters, and the characters '0' till
        // '9' have the ASCII values of 48 till 57. So if we just subtract
        // 48 from the given character, we have the digit the character
        // represents.
        int digitA = a.charAt(i) - 48;
        int digitB = b.charAt(i) - 48;

        // Add both digits and the carry.
        int resultingNumber = digitA + digitB + carry;
        if (resultingNumber >= 10) {
            // We only need the last digit, so we're using the modulo
            // operator, which calculats the remainder. Then we prepend our
            // number to our result string, creating a new result string.
            // You should rather use the StringBuilder class, but for
            // readability, I didn't.
            result = (resultingNumber % 10) + result;
            carry = 1;
        }
        else {
            result = resultingNumber + result;
            carry = 0;
        }
    }
    // Add the last carry to our result string, if available.
    if (carry > 0) {
        result = carry + result;
    }
    return result;
}