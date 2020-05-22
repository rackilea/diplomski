public static boolean isPalindrome(String userPal) {
    if (userPal == null) {
        return false;
    } else if (userPal.length() < 2) {
        return true;
    } else if (userPal.length() == 2) {
        return userPal.charAt(0) == userPal.charAt(1);
    }
    return userPal.charAt(0) == userPal.charAt(userPal.length() - 1)
            && isPalindrome(userPal.substring(1, userPal.length() - 1));
}