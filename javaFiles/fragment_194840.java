import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyEventManager {

    private Map<String, Double> amountMap = new HashMap<>();
    public String amountType;
    public double amount;

    public static void main(String[] args) throws IOException {
        MyEventManager eventManager = new MyEventManager();
        eventManager.runEvent();
    }

    private void runEvent() throws IOException {
        System.out.printf("This program will read a text file and add data to it, then compute the results.\n\n");

        File inputFile = new File("Event.txt");
        handleFileInput(inputFile);

        System.out.println("Are there any more amounts to add that where not in the text file?\n");
        Scanner keyboard = new Scanner(System.in);
        String questionOne = keyboard.next();

        if ("y".equalsIgnoreCase(questionOne)) {
            do {
                validationMethodType();
                validationMethodAmount();
                addAmount(amountType, amount);

                System.out.println("Are there any more amounts to add that where not in the text file?\n");
                keyboard = new Scanner(System.in);
                questionOne = keyboard.next();
            } while (questionOne.equalsIgnoreCase("y"));
        }

        displayResults();
    }

    private void handleFileInput(File inputFile) throws IOException {
        try (Scanner scanFile = new Scanner(inputFile)) {
            int lineCount = 0;
            while (scanFile.hasNext()) {
                if (scanFile.hasNextLine()) {
                    String[] temp = scanFile.nextLine().split(" ");

                    String amountType = temp[0];
                    double amount = new Double(temp[1]);

                    try {
                        checkType(amountType);
                        checkAmount(amount);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        continue;
                    }

                    addAmount(amountType, amount);
                    lineCount++;
                }
            }
            System.out.println("Total number of valid lines read was " + lineCount);
        } catch (FileNotFoundException e) {
            System.out.println("Error code 4: The file " + inputFile.getName() + " was not found!");
        }
    }

    private String validationMethodType() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.printf("\nPlease enter an amount type ('T' - Tickets), ('D' - Donations), ('E' - Expenses): ");
        amountType = keyboard.next().toUpperCase();

        if (amountTypeValid(amountType)) {
            do {
                System.out.printf("\nInvlaid amount entered...");
                System.out.printf("\nPlease enter an amount type ('T' - Tickets), ('D' - Donations), ('E' - Expenses): ");
                amountType = keyboard.next().toUpperCase();
            }
            while (amountTypeValid(amountType));
        }

        return amountType;
    }

    private double validationMethodAmount() {
        Scanner keyboard = new Scanner(System.in);
        System.out.printf("\nPlease enter an amount (amount must be positive and non-zero): ");
        amount = keyboard.nextInt();

        if (amount <= 0) {
            do {
                System.out.printf("\nInvlaid amount entered...");
                System.out.printf("\nPlease enter an amount (amount must be positive and non-zero): ");
                amount = keyboard.nextInt();
            }
            while (amount <= 0);
        }

        return amount;
    }

    private void checkAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Error code 1: Amount should be larger then 0");
        }
    }

    private void checkType(String type) {
        if (amountTypeValid(type)) {
            throw new IllegalArgumentException("Error code 2: Invalid input, data will be ignored");
        }
    }

    private void addAmount(String amountType, double amount) {
        if (amountMap.containsKey(amountType)) {
            double currentAmount = amountMap.get(amountType);
            amountMap.put(amountType, currentAmount + amount);
        } else {
            amountMap.put(amountType, amount);
        }
    }

    private boolean amountTypeValid(String type) {
        return !type.equalsIgnoreCase("T") && !type.equalsIgnoreCase("D") && !type.equalsIgnoreCase("E");
    }

    private void displayResults() {
        double ticket = amountMap.containsKey("T") ? amountMap.get("T") : 0;
        double donated = amountMap.containsKey("D") ? amountMap.get("D") : 0;
        double spent = amountMap.containsKey("E") ? amountMap.get("E") : 0;
        double income = ticket + donated;
        double profits = income - spent;
        System.out.printf("\nTotal Ticket Sales: " + "%8.2f", ticket);
        System.out.printf("\nTotal Donations: " + "%11.2f" + " +", donated);
        System.out.printf("\n                    --------");
        System.out.printf("\nTotal Income: " + "%14.2f", income);
        System.out.printf("\nTotal Expenses: " + "%12.2f" + " -", spent);
        System.out.printf("\n                    --------");
        System.out.printf("\nEvent Profits: " + "%13.2f", profits);
        System.out.println();
    }
}