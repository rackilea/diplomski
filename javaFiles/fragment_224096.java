import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int inputs = scanner.nextInt();
            int sum = 0;
            while (inputs-- > 0) {
                // input 1 2500 in one line is read as two different inputs
                int row = scanner.nextInt();
                int value = scanner.nextInt();
                sum += value;
            }
            System.out.println(sum);
        }
    }
}