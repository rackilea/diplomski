public static Set<String> getPermutations(final String string, final char c) {
    final Set<String> permutations = new HashSet<>();
    final int indexofChar = string.indexOf(c);
    if (indexofChar <= 0) {
        permutations.add(string);
    } else {
        final String firstPart = string.substring(0, indexofChar + 1);
        final String firstPartReplaced = firstPart.replace(c, '*');
        final String lastPart = string.substring(indexofChar + 1, string.length());
        for (final String lastPartPerm : getPermutations(lastPart, c)) {
            permutations.add(firstPart + lastPartPerm);
            permutations.add(firstPartReplaced + lastPartPerm);
        }
    }
    return permutations;
}