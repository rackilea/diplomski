import java.util.ArrayList;
import java.util.Scanner;
public class heya  
{
    public static final int QUIZLIMIT = 5;
    public static final double MAX_SCORE = 15;
    public static Scanner readQuiz;

    public static void main( String[] args ) 
    {
        readQuiz = new Scanner(System.in);

        while (readQuiz.hasNextLine()) {
            ArrayList<Integer> quizMarks = readArrayList(readQuiz.nextLine());
            computerAverage(quizMarks);
        }
    }
    // Load quiz marks
    public static ArrayList<Integer> readArrayList(String input)
    {
        ArrayList<Integer> quiz = new ArrayList<Integer>();
        Scanner readQuiz = new Scanner(input);
        int i = 1;
        while (i <= QUIZLIMIT)
        {
            if (readQuiz.hasNextInt()) {
                quiz.add(readQuiz.nextInt());
                i++;
            } else {
                readQuiz.next(); // toss the next read token
            }
        }
        return quiz;
     }
     //Computer the average of quiz marks
     public static void computerAverage(ArrayList<Integer>quiz)
     {
        double total = 0 ;
        for(Integer value : quiz)
        {
            total = total + value;
        }
        total *= MAX_SCORE/100;
        System.out.println("Quiz Avg: "+ total / QUIZLIMIT ); 
    }
}