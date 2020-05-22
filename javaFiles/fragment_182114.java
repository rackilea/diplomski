public static int getTheNumber(int[] factors) {
    List<Integer> f = new ArrayList<Integer>();
    for (int factor : factors) {
        f.add(factor); // after autoboxing the same as: f.add(Integer.valueOf(factor));
    }
    Collections.sort(f);
    return f.get(0) * f.get(f.size() - 1);
}