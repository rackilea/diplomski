public static String stringOfSize(int size, char ch)
{
    final char[] array = new char[size];
    Arrays.fill(array, ch);
    return new String(array);
}