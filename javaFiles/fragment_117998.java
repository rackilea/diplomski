import java.util.Scanner;

public class Test {

    public static final void main(String[] args) {
        long a = 0, b = 0, c = 0, d = 0;

        System.out.println("Type some numbers!");

        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        Scanner ln = new Scanner(in);

        while (ln.hasNextLong()) {
            a = ln.nextLong();
            if (a > b) {
                b = a;
                ++d;
            }
            ++c;
        }

        System.out.println("\n   info:");
        System.out.println("     highest:" + b);
        System.out.println("     iterations:" + c);
        System.out.println("     overrides:" + d);
    }
}