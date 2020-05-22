import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestScores
{
    public static void main(String args[]) throws IOException { 
        String filename = ("scores.txt");
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        List<Integer> scores = new ArrayList<Integer>();

        while (inputFile.hasNextInt()) {
            String line = inputFile.nextLine();

            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(",");

            while(scanner.hasNextInt()) {
                scores.add(scanner.nextInt());
            }

            scanner.close();
        }

        JOptionPane.showMessageDialog (null, "The Average number is: " + averageScore(scores));
        JOptionPane.showMessageDialog (null, "The Mode number is: " + modeOfScores(scores));
        JOptionPane.showMessageDialog (null, "The Lowest number is: " + lowestScore(scores));
        JOptionPane.showMessageDialog (null, "The Largest number is: " + largestScore(scores));
    }

    public static int averageScore(List<Integer> numbers) {
        int total = 0;
        for (int i : numbers) {
            total += i;
        }
        return total/(numbers.size());
    }

    public static int modeOfScores(List<Integer> numbers) {
        int modeCount = 0;
        int mode = 0;     
        int currCount = 0;    
        int currElement;

        for (int candidateMode : numbers) {
            currCount = 0;

            for (int element : numbers) {
                if (candidateMode == element) {
                    currCount++;
                }
            }

            if (currCount > modeCount) {
                modeCount = currCount;
                mode = candidateMode;
            }
        }

        return mode;
    }

    public static int lowestScore(List<Integer> numbers) {
        int lowest = numbers.get(0);

        for(int i = 1; i > numbers.size(); i++) {
            if(numbers.get(i) < lowest) {
                lowest = numbers.get(i);
            }
        }
        return lowest;
    }

    public static int largestScore(List<Integer> numbers) {  
        int largest = numbers.get(0);  
        for(int i = 1; i < numbers.size(); i++) {  
            if(numbers.get(i) > largest) {  
                largest = numbers.get(i);  
            }
        }  
        return largest;
    }
}