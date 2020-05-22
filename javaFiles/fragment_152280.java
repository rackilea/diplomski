public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean keepGoing = true; //As long as this is true the while statement will continue;
        while (keepGoing) {
            System.out.println("Enter a number");
            int x = scan.nextInt();

            //logic
            if (x == 1) {
                System.out.println("X is equal to 1");
            } else if (x == 2)
                System.out.println("X is equal to 2");


            //prompts the user if they want to keep going.
            System.out.println("Would you like to keep going? Y/N");

            String decision = scan.next();
            if (decision.equalsIgnoreCase("y")) {
                keepGoing = true;
            } else {
                System.out.println("Quitting...");
                keepGoing = false;

            }
        }
    }
}
`