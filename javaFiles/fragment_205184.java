package userinfo;

import java.util.Scanner;

public class UserInfo {

public static void main(String[] args) {

    String name;
    int teleNum;
    String inputTeleNum;
    String yes = "YES";
    String no = "NO";

    Scanner userInput = new Scanner(System.in);

    while (true) {

        System.out.println("Enter your name:");
        name = userInput.next();

        System.out.println("Please varify your name by typing YES or NO");

        String input = userInput.next();

        if (input.equals(yes)) {
            System.out.println("Your name is: " + name);
        } else if (input.equals(no)) {
            System.out.println("Enter your name again");

        }

        while (true) {

            System.out.println("Enter your telephone number:");
            teleNum = userInput.nextInt();

            System.out.println("Please varify your telephone number by typing YES or NO");

            inputTeleNum = userInput.next();

            if (inputTeleNum.equals(yes)) {
                System.out.println("Your telephone num is: " + teleNum);
            } else if (inputTeleNum.equals(no)) {
                System.out.println("Enter your tele number again: ");

            }

        }

    }

}

}