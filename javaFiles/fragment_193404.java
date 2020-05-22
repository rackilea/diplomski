import java.util.Scanner;

public class SchoolHomework {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter number only:");
            int line = sc.nextInt();
            int cnt = 1;
            int cnt2 = 0;
            while (cnt <= line) {
                cnt2 = 1;
                while (cnt2 <= line) {
                    if (cnt2 <= line) {
                        System.out.println("*");
                    } else {
                        System.out.println("#");
                    }
                    cnt2++;
                }
                System.out.println(" ");
                cnt++;
            }
        }
    }
}