import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class one {

public static void main(String args[]) {
    int mostUsedNumber = 0;
    int mostUsedCount = 0;

    int maxNo=-1;
    int minNo=-1;

    List numberList = new ArrayList<Integer>();

    List mostOccuranceList = new ArrayList<Integer>();

    System.out.println("I will track all your numbers!");
    System.out.println("Enter any digits between 1 and 9.");
    System.out.println("Enter '-1' when done:");

    Scanner scn = new Scanner(System.in);

    while (scn.hasNext()) {

        String userInput = scn.next().trim();

        int user_input = Integer.parseInt(userInput);

        if(maxNo==-1 && minNo ==-1){
            maxNo=minNo=user_input;
        }

        if (user_input > 0 && user_input < 10) {

            // returns the number of occurrences
            int occurrences = Collections.frequency(numberList,user_input);

            if (occurrences == mostUsedCount) {
                mostOccuranceList.add(user_input);
            } else if (occurrences > mostUsedCount) {
                mostUsedCount = occurrences;
                // emptying the most occurrence list since current input is the most frequent number
                mostOccuranceList.removeAll(mostOccuranceList);
                mostOccuranceList.add(user_input);
            }
            if(user_input>maxNo)
            {
                maxNo=user_input;
            }

            if(user_input<minNo){
                minNo=user_input;
            }
            numberList.add(user_input);

        }

        mostUsedNumber+=1;
        mostUsedNumber=Integer.parseInt(mostOccuranceList.get(0).toString());
        if (userInput.equals("-1")) {
            System.out.println("Your tracked data:");
            System.out.println("Longest run: " + mostOccuranceList + " entered " + mostUsedCount + " .");
            System.out.println("Maximum Number :- "+maxNo);
            System.out.println("Minimum Number :- "+minNo);
            break;
        }
    }
}

}