import java.util.Arrays;
import java.util.HashMap;

public class StudentDatabase {
    private HashMap<String, int[]> quizmarks;

    public static final int NUM_QUIZZES = 10;
    public static final int MIN_GRADE = 0;
    public static final int MAX_GRADE = 100;


    public StudentDatabase() {
        quizmarks = new HashMap<>();
    }

    private String formatName(String name) {
        String caps = "";
        String lowercase = "";
        if (name != null && name.length() > 0) {
            caps = name.substring(0, 1).toUpperCase();
        }
        if (name.length() > 1) {
            lowercase = name.substring(1).toLowerCase();
        }
        return caps + lowercase;
    }


    public void addStudent(String studentName) {
        if (studentName != null) {
            int[] marks = new int[NUM_QUIZZES];
            quizmarks.put(formatName(studentName), marks);
        }
    }

    public void showQuizzes(String student) {
        System.out.println(Arrays.toString(quizmarks.get(student)));
    }

    public void changeQuizMark(String studentName, int whichQuiz, int newMark) {
        if (whichQuiz < NUM_QUIZZES && newMark >= MIN_GRADE && newMark =< MAX_GRADE) {
            quizmarks.get(studentName)[whichQuiz] = newMark;
        }
    }

}