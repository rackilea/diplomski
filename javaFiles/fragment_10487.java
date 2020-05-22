public class test {

    public static String s1 = "alpha";
    public static String s2 = "delta";
    public static String s3 = "omega";
    public static String s4 = "alpha";

    public static void main(String[] args) {

        System.out.println(recursiveCompare(s1, s2));  // -1  good
        System.out.println(recursiveCompare(s3, s1));  //  1  good
        System.out.println(recursiveCompare(s4, s1));  //  1  FAIL!!! should be 0
        System.out.println(recursiveCompare(s2, s3));  // -1  good
        System.out.println(recursiveCompare(s1, s1));  // -1  FAIL!!! should be 0

    }

    public static int recursiveCompare(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            if ((s1.length() == 0 && s2.length() == 0)) {
                return 0;
            } else if (s1.length() != 0) {
                return 1;
            } else {
                return -1;
            }
        }
        if (s1.charAt(0) < s2.charAt(0)) {
            return -1;
        } else if (s1.charAt(0) > s2.charAt(0)) {
            return 1;
        } else if (s1.charAt(0) == s2.charAt(0)) {
            return 0;
        } else {
            return recursiveCompare(s1.substring(1), s2.substring(1));
        }
    }

}