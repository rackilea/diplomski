import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    private static String   fileName;
    private static String[] genders, emails;
    private static double salaries[];
    private static int    userCount;
    private static int[]  ages;
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("enter filename");
        fileName = in.nextLine();
        File myFile = new File(fileName);
        getInput();
        display();
        FileWriter fWriter = null;
        BufferedWriter writer = null;
        try {
            fWriter = new FileWriter(myFile);
            writer = new BufferedWriter(fWriter);
            writer.write(display().toString());
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    public static ArrayList<String> display() throws FileNotFoundException {
        ArrayList<String> data = new ArrayList<String>();

        for (int i = 0; i < genders.length; i++) {

            data.add(ages[i] + ";" + genders[i] + ";" + emails[i] +
                     ";" + salaries[i]);
        }

        for (int i = 0; i < genders.length; i++) {

            System.out.println(ages[i] + ";" + genders[i] + ";" + emails[i] +
                               ";" + salaries[i]);
        }
        return data;
    }

    private static void getInput() {
        System.out.print("How many users do you wish to enter: ");
        int userCount = in.nextInt();
        ages = new int[userCount];
        genders = new String[userCount];
        emails = new String[userCount];
        salaries = new double[userCount];

        for (int i = 0; i < userCount; i++) {
            System.out.print("Please enter your age for person " + (i + 1) +
                             ": ");
            ages[i] = in.nextInt();
            while (ages[i] < 20 || ages[i] > 30) {
                System.out.println("invalid age please re enter again");
                ages[i] = in.nextInt();
            }
            in.nextLine();
        }
    }
}