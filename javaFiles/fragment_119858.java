public static Set<CharSequence> printAllPalindromes(String input) {
    if (input.length() <= 2) {
        return Collections.emptySet();
    }
    Set<CharSequence> out = new HashSet<CharSequence>();
    int length = input.length();
    for (int i = 1; i <= length; i++) {
        for (int j = i - 1, k = i; j >= 0 && k < length; j--, k++) {
            if (input.charAt(j) == input.charAt(k)) {
                out.add(input.subSequence(j, k + 1));
            } else {
                break;
            }
        }
    }
    return out;
}