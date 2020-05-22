import java.util.Scanner;

public class Test2 {
public static void main(String[] args) {
    Scanner inp = new Scanner(System. in );
    System.out.println("How many students?");
    int num = inp.nextInt();
    System.out.println("How many times?");
    int times = inp.nextInt();
    int x[] = new int[num];
    int matches = 0;
    boolean out = false;
    for (int i = 0; i < times; i++) {
        for (int j = 0; j < num; j++) {
            x[j] = (int)(Math.random() * 365) + 1;
        }
        for (int j = 0; j < num; j++) {
            for (int k = j + 1; k < num; k++) {
                if (x[j] == x[k]) {
                    matches++;
                    out = true;
                    break;
                }
            }
            if (out) {
                out = false;
                break;
            }
        }
    }
    double prob = (double) matches / times;
    System.out.println("The probability for two students to share a birthday is " + prob + ".");
}
}