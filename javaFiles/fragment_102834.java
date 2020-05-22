import java.util.Scanner;
    public class CountingPrimes {
        public static void main(String[] args) {
            int flag = 0, i, j;
            int count = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the 1st number: ");
            int firstNum = sc.nextInt();

            System.out.println("Enter the 2nd number: ");
            int secondNum = sc.nextInt();
            System.out.println("Counting prime numbers between "
                    + firstNum + " and " + secondNum + ":");
            for (i = firstNum; i <= secondNum; i++) {
                for (j = 2; j < i; j++) {
                    if (i % j == 0) {
                        flag = 0;
                        break;
                    } else {
                        flag = 1;
                    }
                }
                if (flag == 1) {
                    System.out.println(++count + "." + i);
                }
            }
        }
    }