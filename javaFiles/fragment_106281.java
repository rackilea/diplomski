import java.util.Scanner;

public class Add {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            sum += value;
            System.out.println("sum = " + sum);
        }
    }
}