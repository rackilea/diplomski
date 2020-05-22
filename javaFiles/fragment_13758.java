public static byte[] byteIncrement(byte[] array) {
    byte[] r = array.clone();
    int carry = 1; // as we are incrementing
    for ( int i = array.length - 1; i >= 0; i-- ) { // LSB to MSB
        int sum = (array[i] & 0xff)+carry;
        r[i] = (byte) sum;
        carry = sum >>> 8;
    }
    return r;
}