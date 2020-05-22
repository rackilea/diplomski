public static String toBinaryStringWithLeadingZeros(int x) {
    StringBuffer buf = new StringBuffer(32);
    char[] arr = new char[Integer.numberOfLeadingZeros(x)];
    Arrays.fill(arr, '0');
    buf.append(arr);
    buf.append(Integer.toBinaryString(x));
    return buf.toString();
}