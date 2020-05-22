import java.util.Scanner;

public class Main {
    public static String createMenu(String[] listOfChoices, String menuTitle) {
        String bigStr = menuTitle + "\n\n";
        int count = 1;
        for (int i = 0; i < listOfChoices.length; i++) {
            String littleStr = count + ". " + listOfChoices[i] + "\n";
            count = count + 1;
            bigStr = bigStr + littleStr;
        }
        return bigStr;
    }

    public static int getValidChoice(int numChoices, String menu) {
        System.out.println(menu);
        boolean error = true;
        Scanner choice = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        String number = choice.next();
        char[] inputArray = new char[number.length()];
        for (int i = 0; i < number.length(); i++) {
            inputArray[i] = number.charAt(i);
            if (Character.isDigit(inputArray[i])) {
                error = false;
            }
        }
        while (error == true || Float.valueOf(number) > numChoices || Float.valueOf(number) < 1) {
            System.out.println("Invalid choice -- please try again\n");
            System.out.println(menu);
            choice = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            number = choice.next();
            inputArray = new char[number.length()];
            for (int i = 0; i < number.length(); i++) {
                inputArray[i] = number.charAt(i);
                if (Character.isDigit(inputArray[i])) {
                    error = false;
                }
            }
        }
        return Integer.valueOf(number);
    }

    public static void main(String[] args) {
        String[] chList = { "Add New Employee", "Delete Employee", "Change Employee Name", "Print Employee Roster",
                "Quit" };
        String menuStr = createMenu(chList, "Main Menu");
        int ch = getValidChoice(chList.length, menuStr);
        System.out.println(ch);
    }
}