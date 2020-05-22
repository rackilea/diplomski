/**
 * Provides the same functionality as Integer.parseInt(String s), but throws
 * a custom exception for out-of-range inputs.
 */
int parseIntWithOverflow(String s) throws Exception {
    int result = 0;
    try {
        result = Integer.parseInt(s);
    } catch (Exception e) {
        try {
            new BigInteger(s);
        } catch (Exception e1) {
            throw e; // re-throw, this was a formatting problem
        }
        // We're here iff s represents a valid integer that's outside
        // of java.lang.Integer range. Consider using custom exception type.
        throw new NumberFormatException("Input is outside of Integer range!");
    }
    // the input parsed no problem
    return result;
}