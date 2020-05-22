public class Example {

    public static void main(String[] args) {
        int x = 0, n = 0, p = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number to check even or odd: ");
        x = sc.nextInt();
        evenOdd(x);
        System.out.println("Enter your number to make a box: ");
        n = sc.nextInt();
        boxMake(n);
        System.out.println("Enter a number to check if prime: ");
        p = sc.nextInt();
        checkPrime(p);
        sc.close();
    }

    public static void evenOdd(int x) {
        if (x % 2 == 0) {
            System.out.println(x + " is even.");
            return;
        }
        System.out.println(x + " is odd.");
    }

    public static void boxMake(int n) {
        for (int i = 0; i < n; i++) {
            for (int x = 0; x < n; x++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void checkPrime(int n) {
        int i;
        int m = 0;
        int flag = 0;
        m = n / 2;
        if (n == 0 || n == 1) {
            System.out.println(n + " is not a prime number");
        } else {
            for (i = 2; i <= m; i++) {
                if (n % i == 0) {
                    System.out.println(n + " is not a prime number");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println(n + " is a prime number");
            }
        }
    }
}