public static boolean checkPangram(String str) {
    char[] s = str.replaceAll("\\s+", "")
                .toCharArray();

    Set<Character> hs = new HashSet<Character>();

    for (int index = 0; index < s.length; index++) {
        hs.add(s[index]);
    }

    return hs.size() == 26;
}