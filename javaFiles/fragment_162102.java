public class Calculator {

    public static void main(String[] args) {
        int a = 2;
        int b = 150;
        int k = 3;
        int count = 0;
        for (int i = a; i <= b; i++) {
            boolean isDivisible = true;
            int num = i;
            while (num != 0) {
                int digit = num % 10;
                if (digit % k != 0) {
                    isDivisible = false;
                    break;
                }
                num /= 10;
            }
            if (isDivisible) {
                count++;
                System.out.println(i+" is one such number.");
            }
        }
        System.out.println("Total " + count + " numbers are divisible by " + k);
    }
}