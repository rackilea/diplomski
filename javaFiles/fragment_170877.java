public static Integer[] main(char[] T, char[] P) {
    List<Integer> results = new ArrayList<>();
    boolean match;
    for (int s = 0; s <= (T.length - P.length); s++) {
        match = true;
        for (int j = 0; j <= P.length - 1; j++) {
            if (T[s + j] != P[j]) {
                match = false;
                break;
            }
        }
        if (match == true) {
            results.add(s);
        }
    }
    return results.toArray(new Integer[results.size()]);
}