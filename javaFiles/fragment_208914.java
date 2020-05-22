public class LockerNumberNoRepeats {
    public static void main(String[] args) {
        System.out.println("Total combinations = " + permutations(4));
    }

    public static int permutations(int targetLength) {
        return permutations("", "0123456789", targetLength);
    }

    private static int permutations(String c, String r, int targetLength) {
        if (c.length() == targetLength) {
            System.out.println(c);
            return 1;
        }

        int sum = 0;
        for (int i = 0; i < r.length(); ++i) {
            sum += permutations(c + r.charAt(i), r.substring(0,i) + r.substring(i + 1), targetLength);
        }
        return sum;
    }
}