public static boolean isAnagram(String s1, String s2) {
    char[] string1 = s1.toCharArray();
    char[] string2 = s2.toCharArray();
    Arrays.sort(string1);
    Arrays.sort(string2);
    return Arrays.equals(string1, string2);
}