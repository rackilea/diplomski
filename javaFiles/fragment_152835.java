public int compare(String s1, String s2) {
    if (s1.length() == s2.length()) {                   
        char[] s1_char = s1.toLowerCase().toCharArray();
        char[] s2_char = s2.toLowerCase().toCharArray();
        Arrays.sort(s1_char);
        Arrays.sort(s2_char);

        for (int i = 0; i < s1_char.length; i++) {
            if (s1_char[i] != s2_char[i]) {
                return (int)(s1_char[i] - s2_char[i]);
            }
        }
        return 0;
    } else {
        return s1.length() - s2.length();
    }
}