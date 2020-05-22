import java.util.Scanner;

public class WallisPi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        double pi = 2;
        int a = 2;
        int b = 3;

        for (int i = 0; i <= n; i++){
            pi *= (double) a / (double) b;
            if (a > b) {
                b += 2;
            } else {
                a += 2;
            }
        }

        pi *= 2;

        double acc = Math.PI - pi;

        System.out.println("The approximation of pi is " + pi + ".");
        System.out.println("It is " + acc + " off.");
    }
}