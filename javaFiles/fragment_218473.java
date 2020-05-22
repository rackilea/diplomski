import java.util.Scanner;

public class hil {
    public static void main(String[] args) {
        Scanner m = new Scanner(System.in);

        System.out.print("Insert a number:");
        int num = m.nextInt();

        int[] ar = {10, 20, 30, 40, 50};
        int sum = 0;
        Boolean inArray = false;
        for (int n : ar) {
            sum += n;
            if (num == n) {
                inArray = true;
            }
        }
        System.out.println(inArray);
        System.out.println(sum);
    }
}