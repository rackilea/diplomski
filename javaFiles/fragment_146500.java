import java.util.Scanner;

public class S {

public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("how many lines do you want to enter");
    int n = s.nextInt();

    System.out.println("I want to enter " + n + " lines ");
    n = n + 1;
    String[] str;
    str = new String[n];
    int count = 0;
    for (int i = 0; i < n; i++) {
        str[i] = s.nextLine();
        System.out.println(str[i]);
        count++;
    }
    if (count == n) {
        System.out.println("Reversed output");

        for (int i = n - 1; i >= 0; i--) {
            System.out.println(str[i]);
        }
    }
}