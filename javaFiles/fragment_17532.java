String sortString(String s) {
    char[] chars = s.toCharArray();
    java.util.Arrays.sort(chars);
    return new String(chars);
}

boolean isPermutation(String s1, String s2) {
    if(s1.length() != s2.length()) {
        return false;
    }
    s1 = sortString(s1);
    s2 = sortString(s2);
    return (s1.compareTo(s2) == 0);
}