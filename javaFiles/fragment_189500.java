import java.util.Arrays;
import java.util.Scanner;

public class Question {
    public static void main(String[] args) {
        Scanner userTypes = new Scanner(System.in); //new object for user input
        String[] respondents = {"Cormac", "Orla", "Paul", "Sarah"};
        String[] questions = {"Are you allergic to Dairy?", "Are you allergic to nuts?", "Are you gluten intolerent?"};
        String[][] decisions = new String [4][3];//You have 4 respondents and You have 3 questions
        int dairy= 0;
        int nuts= 0;
        int gluten=0;
        for (int i=0; i<= respondents.length -1 ;i++) {
            System.out.println(respondents[i]);
            for (int j=0; j<= questions.length -1; j++) {
                System.out.println(questions[j]);
                decisions[i][j]=userTypes.nextLine();
                }
            System.out.println("Decisions :: "+Arrays.toString(decisions[i]));//Need to print the result per user
        }
        System.out.println("Allergy Results");//If you are only interested in dairy decision for the 4 user
        for (int k=0; k <= respondents.length - 1; k++ ){
            if (decisions[k][0].equals("Yes")) {//for all user check the first decision (as your first question is about dairy)
                dairy= dairy + 25;
            }
        }
        System.out.println("Dairy Allergy Results = " + dairy + "%");           
        userTypes.close();
    }
}