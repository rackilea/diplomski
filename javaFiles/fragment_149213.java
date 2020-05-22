public static void permutation(String prefix, String str, int len) {
    int n = str.length();
    if (prefix.length() == len) {
        System.out.println(prefix);
    } else {
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), len);
    }
}