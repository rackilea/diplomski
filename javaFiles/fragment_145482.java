import java.util.Scanner;

public class test {
public static void main (String args []) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter you String: ");
    String  bin = sc.nextLine();

    int length = bin.length();
    int j = 0;
    int sum = 0;

    if (length != 0) {
        for (int i = length - 1; i >= 0; i--) {
            if (bin.charAt(i) == '0' || bin.charAt(i) == '1') {
                String s = bin.charAt(j) + "";
                sum = (int) (sum + (Integer.valueOf(s)) * (Math.pow(2, i)));
                j++;
            } else {
                System.out.println("illegal input.");
            }
        }
        System.out.println(sum);
    } else {
        System.out.println("illegal input.");

    }
}
}