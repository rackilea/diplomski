public static ArrayList<Integer> getPermission(int day) {
    List<Integer> places = Arrays.asList(1, 2, 4, 8, 16, 32, 64);
    ArrayList<Integer> d = new ArrayList<Integer>();
    for (Integer i : places) {
        if (bitWiseAnd(day, i)) {
            d.add(i);
        }
    }
    return d;
}

public static boolean bitWiseAnd(int bitwise, int operator) {
    return (bitwise & operator) > 0;
}