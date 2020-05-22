import java.util.Scanner;

public class Test {



public static void main(String[] args) throws java.io.IOException {


    Scanner reader = new Scanner(System. in );
    Boolean exit = false;

    while (!exit) {
        System.out.println("Enter a number between 1-1000: ");
        int n = reader.nextInt();
        if (n < 0 || n > 1000) {

            System.out.println("That number was invalid");
        } else {
            exit = true;
            if (90 <= n && n <= 110) System.out.println(n + " is close to 100");
            if (190 <= n && n <= 210) System.out.println(n + " is close to 200");
            if (290 <= n && n <= 310) System.out.println(n + " is close to 300");
            if (390 <= n && n <= 410) System.out.println(n + " is close to 400");
            if (490 <= n && n <= 510) System.out.println(n + " is close to 500");
            if (590 <= n && n <= 610) System.out.println(n + " is close to 600");
            if (690 <= n && n <= 710) System.out.println(n + " is close to 700");
            if (790 <= n && n <= 810) System.out.println(n + " is close to 800");
            if (890 <= n && n <= 910) System.out.println(n + " is close to 900");
        }
    }
}

}