public static byte[] toByteArray(String[] arr) {
    byte[] res = new byte[arr.length];

    for (int i = 0; i < arr.length; i++)
        res[i] = Byte.parseByte(arr[i]);

    return res;
}