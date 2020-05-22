import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class StackTest {

    public static void main(String[] args) {
        actionPerformed();
    }

    public static void actionPerformed() {

        ArrayList<String> allQuestions = new ArrayList<String>();
        File file = new File("D:/me/test.txt");
        int numberOfRandomQuestions = 10;
        try {
            // Read line by line from the file
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                allQuestions.add(line);
            }
            scan.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < numberOfRandomQuestions; i++) {
            Random randNum = new Random();

            int randQuestionIndex = randNum.nextInt(numberOfRandomQuestions);
            System.out.println();
            String randomQuestion = allQuestions.get(randQuestionIndex);
            JOptionPane.showMessageDialog(null, randomQuestion.replace("/", "\n"));
        }
    }
}