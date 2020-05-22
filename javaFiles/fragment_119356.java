public class E4 {

    public static void main(String[] args) {

        int product = 0;

        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                product = x * y;
                int rev = reverseInt(product);
                if (rev == product) {
                    System.out.println(rev);
                }

            }
        }
    }

    private static int reverseInt(int product) {
        int rev = 0;
        while (product != 0) {
            rev = rev * 10;
            rev += product % 10;
            product = product / 10;
        }
        return rev;
    }
}