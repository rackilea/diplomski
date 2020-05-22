package se.wederbrand.stackoverflow;

public class KPalindrome {
    public static void main(String[] args) {
        KPalindrome kPalindrome = new KPalindrome();
        String s = args[0];
        int k = Integer.parseInt(args[1]);
        if (kPalindrome.testIt(s, k)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    boolean testIt(String s, int k) {
        if (s.length() <= 1) {
            return true;
        }

        while (s.charAt(0) == s.charAt(s.length()-1)) {
            s = s.substring(1, s.length()-1);

            if (s.length() <= 1) {
                return true;
            }
        }

        if (k == 0) {
            return false;
        }

        // Try to remove the first or last character
        return testIt(s.substring(0, s.length() - 1), k - 1) || testIt(s.substring(1, s.length()), k - 1);
    }
}