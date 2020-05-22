package com.stackoverflow.framework;

import java.util.LinkedList;
import java.util.Scanner;

public class Record {

    static Scanner input = new Scanner(System.in);

    public static String readData() {
        return (input.nextLine());
    }

    public static void main(String[] args) {
        BankMethods method = new BankMethods();

        int optionSelected = 0;

        while (true) {

            System.out.println("5. Add a New Record");
            System.out
                    .println("6. Change the Phone Number in the Current Record");

            optionSelected = Integer.parseInt(readData());

            if (optionSelected == 5) {
                // Scanner getRecord = new Scanner(System.in);
                System.out.println("Enter First Name: ");
                String firstName = readData();
                System.out.println("Enter Last Name: ");
                String lastName = readData();
                System.out.println("Enter Phone Number: ");
                String phoneNumber = readData();
                method.addNewRecord(firstName, lastName, phoneNumber);

            }
            if (optionSelected == 6) {
                System.out.println("What would you like to change your phone "
                        + "number to? ");
                // Scanner getRecord = new Scanner(System.in);
                String newNumber = readData();
                method.changePhoneNumber(newNumber);

            }
        }
    }
}

class BankMethods {
    LinkedList recordInformation = new LinkedList();

    public void addNewRecord(String firstName, String lastName,
            String phoneNumber) {
        recordInformation.add(firstName);
        recordInformation.add(lastName);
        recordInformation.add(phoneNumber);
    }

    public void changePhoneNumber(String newNumber) {
        recordInformation.set(2, newNumber);
        System.out.println(recordInformation);
    }
}