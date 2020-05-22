private static byte boolsToByte(final boolean[] array, final int start) {
    byte b = 0;
    for (int i = 0; i < 8; i++) {
        if (array[start + i])
            b |= 1 << (7 - i);
    }
    return b;
}

public static byte[] convertBoolArrayToByteArray(boolean[] boolArr) {
    byte[] byteArr = new byte[boolArr.length/8];
    for (int i = 0; i < byteArr.length; i++)
        byteArr[i] = boolsToByte(boolArr, 8*i);
    return byteArr;
}