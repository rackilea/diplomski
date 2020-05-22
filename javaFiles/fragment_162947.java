public static Set<String> getAnyPermutations(String strInput) {
    Set<String> resultSet = new HashSet<>();
    char[] inp = strInput.toCharArray();

    for (int bitMask = 0; bitMask < (1 << inp.length); bitMask++) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < inp.length; i++) {
            if ((bitMask & (1 << i)) != 0) {
                str.append(inp[i]);
            }
        }

        if (str.length() > 0) {
            resultSet.add(str.toString());
        }
    }

    return resultSet;
}