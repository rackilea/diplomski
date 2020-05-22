public static boolean isPalindrome(String s, int start, int end) {
    if ((end-start) <= 1)
        return true;
    else if (s.charAt(start) != s.charAt(end))
        return false;
    else return isPalindrome(s, start+1, end-1);
}

public static boolean isPalindrome(String s) {
    return isPalindrome(s, 0, s.length()-1);
}