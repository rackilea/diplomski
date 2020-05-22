/**
 *  Compares byte arrays numerically. The byte arrays must contain the  
 *  UTF-8 encodings of the string representations of numeric values. 
 *  The values can be either integers or decimals.
 *  To get the numbers in the right format, you could create as:
 *  "466".getBytes(StandardCharsets.UTF_8);
 */
class NumericByteArrayComparator implements Comparator<byte[]> {

    static final byte ZERO = (byte) '0';
    static final byte POINT = (byte) '.';
    static final byte DASH = (byte) '-';


    @Override
    public int compare(byte[] leftArray, byte[] rightArray) {
        Numeric left = new Numeric(leftArray);
        Numeric right = new Numeric(rightArray);

        if (notSameSign(left, right)) {
            if (left.isNegative()) {
                return -1;
            }
            return 1;
        }
        // If we haven't returned we know they are the same sign
        if (!left.isDecimal() && !right.isDecimal()) {
            // the values are both whole numbers
            return compareIntegers(left, right);
        }
        // The whole numbers have been dealt with
        // Now we have left two numbers with the same sign. At least one is a decimal
        // Repeat the comparison above with the whole number portion

        if (left.decimalOffset != right.decimalOffset) {
            if (left.isNegative()) { // the values are both negative
                // the shorter is the greater
                return right.decimalOffset - left.decimalOffset;
            } // the values are both positive. The longer is the greater
            return left.decimalOffset - right.decimalOffset;
        }
        // the remaining whole number portions have the same length, compare byte-by-byte
        byte[] leftWhole = Arrays.copyOf(left.bytes, left.decimalOffset);
        byte[] rightWhole = Arrays.copyOf(right.bytes, right.decimalOffset);

        int result;
        if (left.isPositive()) {
            result = compareToSameLength(leftWhole, rightWhole);
        } else {
            result = compareToSameLength(rightWhole, leftWhole);
        }
        if (result != 0) {
            return result;
        }

        // Now we have nothing left to compare but the decimal portions
        if (left.isPositive()) {
            result = compareTo(left.decimalPortion(), right.decimalPortion());
        } else {
            result = compareTo(right.decimalPortion(), left.decimalPortion());
        }
        return result;
    }

    /**
     * Compares the given values, assumed to represent whole numbers
     */
    private int compareIntegers(Numeric left, Numeric right) {
        if (left.length() != right.length()) {
            if (left.isNegative()) { // the values are both negative
                // the shorter is the greater when numbers are negative
                return right.length() - left.length();
            } else {
                // the shorter is the lesser when numbers are positive
                return left.length() - right.length();
            }
        } else {
            // they are the same length & sign and both whole numbers. Compare byte by byte
            int result;
            if (left.isPositive()) {
                result = compareToSameLength(left.bytes, right.bytes);
            } else {
                result = compareToSameLength(right.bytes, left.bytes);
            }
            return result;
        }
    }

    /**
     * Compares byte by byte
     */
    private int compareTo(byte[] left, byte[] right) {
        int minLength = Math.min(left.length, right.length);
        for (int i = 0; i < minLength; i++) {
            int result = NumericByteArrayComparator.compare(left[i], right[i]);
            if (result != 0) {
                return result;
            }
        }
        return left.length - right.length;
    }

    /**
     * Compares byte-by-byte when both of the given arrays are the same length
     */
    private int compareToSameLength(byte[] left, byte[] right) {
        for (int i = 0; i < left.length; i++) {
            int result = NumericByteArrayComparator.compare(left[i], right[i]);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

    /**
     * Compares the two specified {@code byte} values. The sign of the value
     * returned is the same as that of {@code ((Byte) a).compareTo(b)}.
     *
     * @param a the first {@code byte} to compare
     * @param b the second {@code byte} to compare
     * @return a negative value if {@code a} is less than {@code b}; a positive
     * value if {@code a} is greater than {@code b}; or zero if they are equal
     */
    public static int compare(byte a, byte b) {
        return a - b; // safe due to restricted range
    }

    /**
     * Returns true if the arguments have different signs (positive or negative)
     */
    private boolean notSameSign(Numeric p1, Numeric p2) {
        return p1.negative != p2.negative;
    }

    static class Numeric {
        final boolean negative;
        int decimalOffset;
        byte[] bytes;

        Numeric(byte[] n) {

            if (n.length == 0) {
                negative = true;
                decimalOffset = 0;
                bytes = n;
            } else {
                negative = (DASH == n[0]);
                bytes = trimSignAndLeadingZeros(n);
                decimalOffset = indexOf(POINT, bytes);
                if (decimalOffset == -1) {
                    decimalOffset = length();
                } else {  // trim trailing zeros only if this is a decimal number
                    bytes = trimTrailingZeros(bytes);
                }
            }
        }

        boolean isDecimal() {
            return decimalOffset < length();
        }

        int length() {
            return bytes.length;
        }

        /**
         * Returns true if this alphanumeric looks like a negative number
         */
        boolean isNegative() {
            return negative;
        }

        /**
         * Returns true if this alphanumeric looks like a positive number
         */
        boolean isPositive() {
            return !negative;
        }

        /** 
         * Returns the index of the given byte in the given byte array
         */
        int indexOf(byte ch, byte[] bytes) {
            final int max = bytes.length;
            int fromIndex = 0;

            for (int i = fromIndex; i < max; i++) {
                if (bytes[i] == ch) {
                    return i;
                }
            }
            return -1;
        }

        @VisibleForTesting
        byte[] trimSignAndLeadingZeros(byte[] array) {
            int len = array.length;
            int st = 0;

            while ((st < len) && (array[st] == ZERO)
                    || (st < len) && (array[st] == DASH)) {
                st++;
            }
            return ((st > 0) ? substring(st, len, array) : array);
        }

        @VisibleForTesting
        byte[] trimTrailingZeros(byte[] array) {
            int len = array.length;
            int st = len - 1;

            while ((st > 0) && (array[st] == ZERO)) {
                st--;
            }
            return ((st < len - 1) ? substring(0, st + 1, array) : array);
        }

        @VisibleForTesting
        byte[] substring(int start, int end, byte[] original) {
            int length = end - start;
            byte[] part = new byte[length];
            System.arraycopy(original, start, part, 0, length);
            return part;
        }

        @VisibleForTesting
        byte[] decimalPortion() {
            byte[] part = new byte[length() - decimalOffset];
            System.arraycopy(this.bytes, decimalOffset, part, 0, length() - decimalOffset);
            return part;
        }
    }
}