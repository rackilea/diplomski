public class Test {

    public static void main(String[] args) {
        System.out.println(isSubstring("ankur", "ku"));
    }

    public static boolean isSubstring(String str1, String str2) {
        if ((str1 == null) || (str2 == null) || str1.isEmpty()) {
            return false;
        } else if (str1.startsWith(str2)) {
            return true;
        } else {
            return isSubstring(str1.substring(1), str2);
        }
    }
}