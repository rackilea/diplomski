public static String[][] getDArray(final ArrayList<String[]> aList) {
    final int size = aList.size();
    final String[][] ans = new String[size][];

    for(int i = 0; i < size; ++i)
        ans[i] = aList.get(i);

    return ans;
}