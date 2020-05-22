public class StringCombi2 {

    private static int counter = 0;

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            if (prefix.equals("studten")) {
                System.out.println(prefix + " is at iteration: " + counter);
            } else {
                counter++;
            }

        } else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }

    public static void main(String arsd[]) {
        permutation("student");
    }
}