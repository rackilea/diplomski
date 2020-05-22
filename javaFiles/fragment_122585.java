// value=your integer, numBitsInt=how much bit you will use to reverse 
public static int reverseIntBitwise(int value, int numBitsInt) {

    int i = 0, rev = 0, bit;

    while (i++ < numBitsInt) {

        bit = value & 1;

        value = value >> 1;

        rev = rev ^ bit;

        if (i < numBitsInt)
            rev = rev << 1;
    }
    return rev;
}