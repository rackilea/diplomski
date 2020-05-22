import java.util.Scanner;
import java.util.ArrayList;
import java.io.Console;

public class Test {

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
ArrayList<String> studentName = new ArrayList<String>(); 
ArrayList<Double> studentGrade = new ArrayList<Double>();
boolean loop = true;

while (loop) {

    System.out.println(" Please Enter Student Name");
    String student = scanner.nextLine();

        if(student.equals("C"))
        {
          break;    
        }
        else
        {
          studentName.add(student);
        }


    System.out.println("Please enter Student Grade");
    for (int j = 0; j < 4; j++) {

        Double grade = Double.parseDouble(scanner.nextLine());
        studentGrade.add(grade);  
    }    

    System.out.println(studentName);
    System.out.print(studentGrade);
  }
}
}