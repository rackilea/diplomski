public static boolean isPalindromic(int count) {
        String blank = "";
        String convert = count + blank;
        int n = convert.length();
        for (int i = 0; i < (n / 2 + 1); i++) {
            if (convert.charAt(i) != convert.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
}