public static int unpackInteger(byte[] bytes) {
    int sum = 0;
    int mul = 1;

    for (int i=bytes.length-1; i >= 0; i--) {
        sum += (mul * (bytes[i] & 0xff));
        mul <<= 8;
    }
    return sum;
}