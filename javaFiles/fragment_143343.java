import java.util.Comparator;

public class MyComparator implements Comparator<String> {

    private int[] charRank;

    public MyComparator() {
        char[] charOrder = {'Q','W','E','R','T','Y','U','I','O','P','L','K','J','H','G','F','D','S','A','Z','X','C','V','B','N','M'};
        this.charRank = new int[26];
        for(int i=0; i<25; i++) {
            this.charRank[charToInt(charOrder[i])] = i; 
        }
    }

    public int compare(String s1, String s2) {
        // returns
        // Positive integer if s1 greater than s2
        // 0 if s1 = s2
        // Negative integer if s1 smaller than s2
        s1 = s1.toUpperCase();
        s2 = s2.toUpperCase();
        int l = Math.min(s1.length(), s2.length());
        int charComp;
        for(int i=0; i<l; i++) {
            charComp = this.charRank[charToInt(s1.charAt(i))] - charRank[charToInt(s2.charAt(i))];
            if(charComp != 0)
                return charComp;
        }
        return s1.length() - s2.length();
    }

    //works for c between 'A' and 'Z' - upper case letters
    private static int charToInt(char c) {
        return c - 65;
    }

    //works for 0<=i<=25
    private static char intToChar(int i) {
        return (char) (i + 65);
    }

}