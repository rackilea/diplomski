public static String toString(int[] a) {
    if (a == null)
        return "null";
    StringBuilder b = new StringBuilder("[");
    int iMax = a.length - 1;
    if (iMax == -1)
         return b.append(']').toString();;
    for (int i = 0; i < iMax; i++)
        b.append(a[i]).append(", ");
    return b.append(a[iMax]).append(']').toString();
}