static boolean unsignedMultiplyOverflows(final long a, final long b) {
        if (a == 0 || b == 0) {
            return false;
        }

        // now proceed with non-zero input
        // we branch based upon parity of a and b
        final long aHalf = a >>> 1;
        final long bHalf = b >>> 1;
        final byte aLastBit = (byte) (a & 1);
        final byte bLastBit = (byte) (b & 1);
        if (aLastBit == 0) { // a = 2 * aHalf, meaning unsigned representation of a
            return Long.MAX_VALUE / b < aHalf;
        } else if (bLastBit == 0) { // b = 2 * bHalf
            return Long.MAX_VALUE / a < bHalf; // symmetrical to previous case
        } else { // a = 2 * aHalf + 1; b = 2 * bHalf + 1
            return (Long.MAX_VALUE - bHalf) / b < aHalf;
        }
    }