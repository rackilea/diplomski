public static byte[] add(byte[] array1, byte[] array2) {
    byte[] r = new byte[array1.length]; // assuming both arrays are same length
    int carry = 0;
    for ( int i = array.length - 1; i >= 0; i-- ) { // LSB to MSB
        int sum = (array1[i] & 0xff)+(array2[i] & 0xff)+carry;
        r[i] = (byte) sum;
        carry = sum >>> 8;
    }
    return r;
}