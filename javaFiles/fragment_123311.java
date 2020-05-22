public static boolean isPalindrome(String userPal) {
    if (userPal == null) {
        return false;
    } else if (userPal.length() < 2) {
        return true;
    }
    StringBuilder testAgainst = new StringBuilder(userPal);
    return userPal.equals(testAgainst.reverse().toString());
}