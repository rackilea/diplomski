import java.util.Scanner;
import java.util.ArrayList;

public class TestGrades {

public static void main(String[] args) {

Scanner scanner = new Scanner(System.in);
ArrayList<Student> studlist = new ArrayList<Student>(); 

boolean loop = true;
while (loop) {

    System.out.println(" Please Enter Student Name");
    String scanedline = scanner.nextLine();

        if(scanedline.equals("C"))
        {
          break;    
        }
        else
        {
          studlist.add(new Student(scanedline));
        }


    System.out.println("Please enter Student Grade");
        for (int j = 0; j < 4; j++)
        {
    System.out.print(""+j+">");
        Double scannedgrade = Double.parseDouble(scanner.nextLine());
        studlist.get(studlist.size() - 1).grade[j]=scannedgrade;
        }    

    System.out.println(studlist.get(studlist.size() - 1).name);
    for (int j = 0; j < 4; j++)
        System.out.print(studlist.get(studlist.size() - 1).grade[j] + " ");
    System.out.println("");
    }
}

private static class Student 
{
    String name;
    Double [] grade;

    Student (String s)
    {
        this.name = s;
        grade = new Double[4];
    }

}

}