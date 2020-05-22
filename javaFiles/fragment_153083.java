import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean parentsVisiting = false;
        boolean weatherGood = false;
        boolean imRich = false;
        System.out.print("Are Parents Visiting? Y or N ");
        if (input.next().equals("Y"))
            parentsVisiting = true;
        System.out.print("Is the Weather Good? Y or N");
        if (input.next().equals("Y"))
            weatherGood = true;
        System.out.print("Are You Rich? Y or N");
        if (input.next().equals("Y"))
            imRich = true;
        System.out.println("What you should do is: ");
        if (!parentsVisiting && weatherGood && imRich) {
            System.out.println("Go Shopping! ");
        } else if (!parentsVisiting && !weatherGood && !imRich) {
            System.out.println("Stay in!");
        } else {
            System.out.println("Cinema!");
        }
    }
}