import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    private static int numberOfCustomer = 0;
    // List instead of array!
    private static List<Customer> customerList = new ArrayList<Customer>();

    private static void readInCustomer(String file) {
        FileReader freader;
        BufferedReader inputFile;
        try {
            freader = new FileReader(file);
            inputFile = new BufferedReader(freader);
            String strLine;

            while ((strLine = inputFile.readLine()) != null) {
                Customer customer = new Customer();
                customer.ID = strLine;
                customer.name = inputFile.readLine();
                customer.address = inputFile.readLine();
                customer.phone = inputFile.readLine();
                customerList.add(customer); // add to the List!
            }

            inputFile.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not find file " + file
                    + " System will now exit");
            System.exit(1);

        }

        return;
    }

    private static void printCustomer(Customer customer) {
        System.out
                .println("The Customer Data corresponding to Customer Number "
                        + customer.ID + " is:");
        System.out.println("Name:\t\t\t" + customer.name);
        System.out.println("Address:\t\t" + customer.address);
        System.out.println("Telephone:\t\t" + customer.phone);
        System.out.println();
        return;
    }

    private static void printAll() {
        boolean hasID = false;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("All customers from data file " + numberOfCustomer);

        System.out.println(" Here they are!!! ");
        for (Customer customer : customerList) {
            System.out
                    .println("The Customer Data corresponding to Customer Number "
                            + customer.ID + " is:");
            System.out.println("Name:\t\t\t" + customer.name);
            System.out.println("Address:\t\t" + customer.address);
            System.out.println("Telephone:\t\t" + customer.phone);
        }

        if (!hasID) {
            System.out.println("");
        }
        System.out.println("Would you like to go to the menu? (Y or N):");
        String input = keyboard.nextLine();
        char repeat = input.charAt(0);
        if (repeat == 'Y' || repeat == 'y') {
            Menu();
        }
        return;
    }

    private static void Menu() {
        boolean hasID = false;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("YOU MAY CHOOSE FROM THE FOLLOWING OPTIONS:");
        System.out.println("A. SEARCH for a customer by ID number");
        System.out.println("B. DISPLAY the entire Customer List");
        System.out.println("C. RE-LOAD DATA from a different data file");
        System.out.println("D. QUIT:");

        String choice = keyboard.nextLine();

        char repeat = choice.charAt(0);
        if (repeat == 'A' || repeat == 'a') {
            Scostomer();
        }
        if (repeat == 'B' || repeat == 'b') {
            printAll();
        }
        if (repeat == 'C' || repeat == 'c') {
            mainn();
        }
        return;

    }

    public static void Scostomer() {
        boolean hasID = false;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Type in the Id you are search for");

        String customerID = keyboard.nextLine();

        // iterate over the List!
        for (Customer customer : customerList) {
            if (customerID.equals(customer.ID)) {
                hasID = true;
                printCustomer(customer);
                break;
            }
        }

        if (!hasID) {
            System.out.println("Sorry, customer not found.");
        }
        System.out
                .println("Would you like to search for another custnomer? (Y or N):");
        String input = keyboard.nextLine();
        char repeat = input.charAt(0);
        if (repeat == 'Y' || repeat == 'y') {
            Scostomer();
        }
        if (repeat == 'N' || repeat == 'n') {
            Menu();
        }
        return;
    }

    public static void main(String arg[]) {
        Scanner keyboard = new Scanner(System.in);
        System.out
                .println("Enter the fileName that contains the data of your customers: ");
        readInCustomer(keyboard.nextLine());
        Menu();
        return;
    }

    public static void mainn() {
        Scanner keyboard = new Scanner(System.in);

        System.out
                .println("Enter the fileName that contains the data of your customers: ");
        readInCustomer(keyboard.nextLine());
        Menu();
        return;

    }
}