private static String combineString(String s1, String s2) {
    String combined = "";
    for (int i=0; i<Math.max(s1.length(), s2.length()); i++) {
        if (i<s1.length()) { combined += Character.toString(s1.charAt(i)); }
        if (i<s2.length()) { combined += Character.toString(s2.charAt(i)); }
    }
    return combined;
}