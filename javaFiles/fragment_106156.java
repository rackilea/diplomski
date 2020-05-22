import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Grades
{
    public static void main(String[] args)
    {
        Map<String, String> marks = new HashMap<String, String>();
        marks.put("A+", "90-100");
        marks.put("A", "85-89");
        marks.put("A-", "80-84");
        marks.put("B+", "77-79");
        marks.put("B", "73-76");
        marks.put("B-", "70-72");
        marks.put("C+", "67-69");
        marks.put("C", "63-66");
        marks.put("C-", "60-62");
        marks.put("D+", "55-59");
        marks.put("D", "50-54");
        marks.put("F", "0-49");

        Scanner scanner = new Scanner(System.in);
        String grade = scanner.next();

        if(marks.containsKey(grade))
        {
            String markRange = "Your mark range is " + marks.get(grade) + " %";
            System.out.println(markRange);
        }
        else
        {
            System.out.println("Unknown grade");
        }
        scanner.close();
    }
}