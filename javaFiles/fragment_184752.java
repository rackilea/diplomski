import java.io.FileInputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
    try {
        Scanner sc = new Scanner (new FileInputStream(args[0]));
        while (sc.hasNextLine())
            System.out.println (sc.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}