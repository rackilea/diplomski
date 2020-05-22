import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Example {

public static void main(String[] args) {
    String [] students={"Paul", "A", "Paul", "B", "Mike", "B", "Cindy", "A", "Cindy", "B", "Cindy", "C"};

    String[][] grades =  convertArray(students);

    System.out.println("Student - Grades iformation is as follows: ");

    for(String[] stuGrade :  grades)
    {
        System.out.println(Arrays.toString(stuGrade));
    }
}

public static String[][] convertArray(String[] students)
{
    List<List<String>> stuGradeList = new ArrayList<List<String>>();

    List<String> tempStuGrade = new ArrayList<String>();
    for(int i =0; i< students.length; i++)
    {
        /*
         * Handles Name information
         */
        if(i%2 == 0)
        {
            if(!tempStuGrade.contains(students[i]))
            {
                if(tempStuGrade.isEmpty())
                {
                    tempStuGrade.add(students[i]);
                }else
                {
                    stuGradeList.add(new ArrayList<String>(tempStuGrade));

                    /*
                     * Student changed
                     * 
                     * Clear the original list and put the new Student name into temp list
                     */
                    tempStuGrade.clear();
                    tempStuGrade.add(students[i]);
                }
            }

        }else
        {
            //Add Grade to list directly
            tempStuGrade.add(students[i]);


            if(i == students.length-1)
            {
                stuGradeList.add(new ArrayList<String>(tempStuGrade));
            }
        }
    }

    String[][] grades   = new String[stuGradeList.size()][];

    /*
     * Put value of List<List<String>> into 2D Array (String[][])  
     */
    for(int i = 0;i <stuGradeList.size(); i++)
    {
        grades[i] = new String[stuGradeList.get(i).size()];
        grades[i] = stuGradeList.get(i).toArray(grades[i]);
    }

    return grades;
}
}