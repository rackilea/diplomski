private static boolean isPalindrome(Integer possible) {
    String toStr = possible.toString();
    int len = toStr.length();
    if (len % 2 == 1) {
        len = len - 1;
    }

    for (int i = 0; i < len / 2; i++) {
        if (toStr.charAt(i) != toStr.charAt(toStr.length() - (1 + i))) {
            return false;
        }
    }

    return true;
}