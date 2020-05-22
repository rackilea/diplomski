public static List<String> perm(int n) {
    List<String> result = new ArrayList<String>();
    if (n == 1) {
        return Arrays.asList(syllables);
    }
    for (String s : syllables) {
        for (String prefix : perm(n - 1)) {
            result.add(s + prefix);
        }
    }
    return result;
}