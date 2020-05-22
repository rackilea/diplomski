public class Test {
    public static void main(String[] args) {
        // Makes the assumption that the input integer contains an even number of digits.
        int x = 123456;
        String s = Integer.toString(x);
        int half = s.length() / 2;
        String firstHalf = s.substring(0, half);
        String secondHalf = s.substring(half);
        System.out.println(firstHalf);
        System.out.println(secondHalf);
        int sum1 = sumString(firstHalf);
        int sum2 = sumString(secondHalf);
        System.out.println("Sum 1: " + sum1);
        System.out.println("Sum 2: " + sum2);
    }

    private static int sumString(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(s.substring(i, i + 1));
        }

        return sum;
    }
}