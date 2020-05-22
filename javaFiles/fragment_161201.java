public static String listIntToString(List<Integer> list) {
    StringBuilder s = new StringBuilder();
    for (int i: list)
        s.append(i).append(" ");
    return s.toString();
}