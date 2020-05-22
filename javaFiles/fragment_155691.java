static String multiply(String s1, String s2) {
    String result = "";
    String zeroSuffix = "";
    for (int i = s2.length() - 1; i >= 0; i--) {
        if (s2.charAt(i) == '1') {
            result = add(result, s1 + zeroSuffix);
        }
        zeroSuffix += "0";
    }
    return result;
}