import java.util.Scanner;

public class FibNumbers {
        public static void main(String[] args) {
        int f;
        int l;
        long num1;
        long num2;
        int choice;
        long t1 = 0, t2 = 0;
        Scanner sc = new Scanner(System.in);
        Scanner keyboard = new Scanner(System.in);

        System.out.println("For recursion press 1 %n for loop press 2" );
        choice = keyboard.nextInt();
        if(choice == 1) {
            System.out.println("Please enter a value for n");
            f = Integer.parseInt(sc.nextLine());
            t1 = System.nanoTime();
            System.out.println("The Fibonacci number is " + fibonacciR(f) + " using recursion");
            t2 = System.nanoTime();
        }
        else {
            System.out.println("Please enter a value for n");
            l = Integer.parseInt(sc.nextLine());
            t1 = System.currentTimeMillis();
            System.out.println("The Fibonacci number is " + fibonacciL(l) + " using a for loop");
            t2 = System.nanoTime();
        }
        System.out.println("The elapsed time is " + (t2 - t1) + " nano seconds.");
    }

    public static long fibonacciR(long f) {
        if(f == 0) {
            return 0;
        }
        else if(f == 1) {
            return 1;
        }
        else {
            return fibonacciR(f-1) + fibonacciR(f-2);
        }
    }

    public static long fibonacciL(long l) {
        long num1 = 0;
        long num2 = 1;
        long total = l;
        long sumOfTwo;
        for(int i = 0; i < total; i++) {
            sumOfTwo = num1 + num2;
            num1 = num2;
            num2 = sumOfTwo;
        }
        return num1;
    }
}