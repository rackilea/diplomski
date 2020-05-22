public class Oddsum {
    public static int oddSum(int n) {
        int val = 0;
        if (n > 1) {

            if (n % 2 == 0) {
                val = n + oddSum(n - 1);

            } else {
                val = oddSum(n - 1);

            }
        }
        return val;
    }

    public static int request() {
        Scanner in = new Scanner(System.in);
        System.out.println("Give me a positive integer: ");
        int n = in.nextInt();
        if (n < 0) {
            System.out.println("I said positive! ");
            return request();
        }
        return n;
    }

    public static void main(String[] args) {
        int n = request();
        System.out.println(oddSum(n));
    }

}