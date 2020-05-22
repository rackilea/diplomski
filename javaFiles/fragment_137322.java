package test;

import java.util.Scanner;

public class CSE1PGX_A2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final float childCost = 18;
        final float adultCost = 36;
        final float seniorCost = 32.50F;

        boolean continueLoop = true;
        Scanner input = new Scanner(System.in);

            float childTotal = 0;
            float adultTotal = 0;
            float seniorTotal = 0;

        while (continueLoop) {
            int option, confirm=0;

            System.out.println("\t @@@@@ Welcome to Zoos Victoria @@@@@");
            System.out.println("\t \t MAIN MENU \n");
            System.out.println("\t Zoo has the following ticketing options \n");
            System.out.println("\t 1 = Child (4-6 yrs)");
            System.out.println("\t 2 = Adult (16+ yrs)");
            System.out.println("\t 3 = Senior (60+ yrs) \n");
            System.out.println("Enter your option:");

            option = input.nextInt();

            switch (option) {
                case 1: {
                    System.out.println("Enter total No of tickets for Child:");
                    int quantity = input.nextInt();
                    childTotal = quantity * childCost;

                    System.out.println("You are purchasing " + quantity + " child tickets at " + childCost + " each!");
                    System.out.println("Press 1 to confirm");
                    confirm = input.nextInt();
                    if (confirm == 1) {
                        System.out.println("Total amount for child tickets: $" + childTotal);
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter total No of tickets for Adult:");
                    int quantity = input.nextInt();
                    adultTotal = quantity * adultCost ;

                    System.out.println("You are purchasing " + quantity + " adult tickets at " + adultCost + " each!");

                    System.out.println("Press 1 to confirm");
                    confirm = input.nextInt();
                    if (confirm == 1) {
                        System.out.println("Total amount for adult tickets $" + adultTotal);
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter total No of tickets for Senior:");
                    int quantity = input.nextInt();
                    seniorTotal =  quantity * seniorCost ;
                    System.out.println("You are purchasing " + quantity + " senior tickets at " + seniorCost + " each!");

                    System.out.println("Press 1 to confirm");
                    confirm = input.nextInt();
                    if (confirm == 1) {
                        System.out.println("Total amount for senior tickets $" + seniorTotal);
                    }
                    break;
                }
            }

            if (confirm != 1) {
                System.out.println("Incorrect key!");
            }

            System.out.println("Do you wish to continue? (Y/N) ");
            char resume = input.next().charAt(0);

        if (resume != 'y' && resume != 'Y') {
            continueLoop = false;

            System.out.println("Total amount for child tickets: $" + childTotal);
            System.out.println("Total amount for senior tickets $" + seniorTotal);
            System.out.println("Total amount for adult tickets $" + adultTotal);
            float  finalTotal =  childTotal + adultTotal + seniorTotal ;
            System.out.println("Total amount payable: $ " + finalTotal);
        }
        }
    }
}