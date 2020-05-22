import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;


public class ExecuteQuiz {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // ask the user for the filename
        Scanner scan = new Scanner(System.in);

        System.out.print("Which quiz are you taking? ");
        String theFile = scan.nextLine(); // file may contain more than one word
        File fileIn = new File(theFile);

        // ask the user for another filename if the given file doesn't exist
        // exists() method in File class - checks whether file
        // exists and is readable
        while (!fileIn.exists()) {
            System.out.print("Invalid file name! Try again: ");

            theFile = scan.nextLine();

            fileIn = new File(theFile);
        }

        // have a valid file name, create a Scanner object
        Scanner fileScan = new Scanner(fileIn);

        // An arraylist of ALL problems.
        ArrayList<Problem> problems = new ArrayList<Problem>();

        // process the file
        while (fileScan.hasNextLine()) {
            int type = Integer.parseInt(scan.nextLine()); // Get the line in a string
            String question = scan.nextLine();

            switch (type) {
            case 1:
                String WAnswer = scan.nextLine();
                WProblem w = new WProblem(question, WAnswer);
                problems.add(w);
                break;
            case 2:
                String TString = scan.nextLine(); // Gets the string
                boolean TAnswer = Boolean.parseBoolean(TString); // Converts to
                // boolean
                TProblem t = new TProblem(question, TAnswer); // Creates the
                // object
                problems.add(t);
                break;
            case 3:
                String Nanswer = scan.nextLine();
                NProblem n = new NProblem(question, Nanswer);
                problems.add(n);
                break;
            case 4:
                ArrayList<String> options = new ArrayList<String>();
                // Get the answer and add it to the options
                String SAnswer = input.nextLine();
                options.add(SAnswer);

                // add the rest of options
                while (input.nextLine() != null) {
                    String option = input.nextLine();
                    options.add(option);
                }
                // Create new objects
                SProblem s = new SProblem(question, SAnswer, options);

                problems.add(s);
                break;
            case 5:
                ArrayList<String> MAnswer = new ArrayList<String>();
                ArrayList<String> MOptions = new ArrayList<String>();

                // Find all the answers
                while (input.nextLine() != null) {
                    String answer = input.nextLine();
                    MAnswer.add(answer);
                    MOptions.add(answer);
                }

                // get the rest of the options
                while (input.nextLine() != null) {
                    MOptions.add(input.nextLine());
                }

                MProblem m = new MProblem(question, MAnswer, MOptions);
                problems.add(m);
                break;
            case 6:
                // Adding answers into an arraylist
                ArrayList<String> OrderedAnswer = new ArrayList<String>();

                // Add the answers in order
                while (input.nextLine() != null) {
                    OrderedAnswer.add(input.nextLine());
                }
                OProblem o = new OProblem(question, OrderedAnswer);
                problems.add(o);
                break;
            }
            // Analyze the type of problem

        }
    }
}