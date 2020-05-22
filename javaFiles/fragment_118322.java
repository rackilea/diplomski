import java.util.Scanner;

class MyTest {
    public static void main(String args[]) {
        int option;
        Scanner in = new Scanner(System.in);
        do {
            String menu = "\n Please select an option to perform"
            + "\n1 (1) Get all uppercase letters."
            + "\n2 (2) Get every second letter."
            + "\n3 (3) Replace vowels with _ "
            + "\n4 (4) Get a count of all vowels."
            + "\n5 (5) Get position of all vowels."
            + "\n0 (0) Exit Program";
            System.out.println(menu);
            option = in.nextInt();
            switch(option) {
                case 0:
                    System.out.println("Hasta la vista Baby");
                    break;
                case 1:
                    System.out.println("Option 1");
                    break;
                case 2:
                    System.out.println("Option 2");
                    break;
                case 3:
                    System.out.println("Option 3");
                    break;
                case 4:
                    System.out.println("Option 4");
                    break;
                case 5:
                    System.out.println("Option 5");
                    break;
                default:
                    System.out.println("Wrong option");
                    break; //I always use this break, even when not needed.
            }
        } while (option != 0);
    }
}