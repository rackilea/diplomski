import java.util.Scanner;

    public class Test {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner in = new Scanner(System.in);


            System.out.println("Input word to test: ");
            String stringIn = in.nextLine();
            String stringOut = new StringBuilder(stringIn).reverse().toString(); 

            while (!stringIn.matches("[a-zA-Z]+")) {
                System.out.println("Invalid input, try again.");
                stringIn= in.next(); //stops infinite error loop
            }
            stringOut = new StringBuilder(stringIn).reverse().toString();
            if ((stringIn.equalsIgnoreCase(stringOut))) {
                System.out.println("Palindrome detected");
                System.out.println("You entered: " + stringIn);
                System.out.println("Your string reversed is: " + stringOut);

    }       else {
                System.out.println("Not a palindrome");
    }

        }
    }