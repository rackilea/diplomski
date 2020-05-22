public class Test {
    public static void main(String[] args) {
        // Makes the assumption that the input integer contains an even number of digits.
        int x = 123456;
        String s = Integer.toString(x);
        int[] count = new int[2];
        for (int i = 0; i < s.length(); i++) {
            int digit = Integer.parseInt(s.substring(i, i + 1));
            int countIndex = (int)Math.floor(i * 2 / s.length());
            count[countIndex] += digit;
        }

        int half = s.length() / 2;
        System.out.println("First Sum of " + s.substring(0, half) + ": " + count[0]);
        System.out.println("Second Sum of " + s.substring(half) + ": " + count[1]);
    }
}