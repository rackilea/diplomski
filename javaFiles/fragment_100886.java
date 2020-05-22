static boolean isValidUTF16(String s) {
    for (int i = 0; i < s.length(); i++) {
        if (Character.isLowSurrogate(s.charAt(i)) && (i == 0 || !Character.isHighSurrogate(s.charAt(i - 1)))
                || Character.isHighSurrogate(s.charAt(i)) && (i == s.length() -1 || !Character.isLowSurrogate(s.charAt(i + 1)))) {
            return false;
        }
    }
    return true;
}