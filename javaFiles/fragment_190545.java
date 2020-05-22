import java.util.Scanner;

public class StackOverflowTest {
  static String name;
  static int age;
  static int grade;
  static boolean first;
  static boolean running;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter name or command: ");
      name = sc.next();
      if(name.toLowerCase().equals("next")) {
            System.out.println("students.remove(0);");
//          students.remove(0);
      }else if(name.toLowerCase().equals("end")) {
          running = false;
      }else {

//This is where it gets dicey
        if(!sc.hasNext())
            System.out.println("Enter age: ");
        age = sc.nextInt();
        if(!sc.hasNext())
            System.out.println("Enter grade: ");
        grade = sc.nextInt();

        if(first) {
            System.out.println("students.add(new Student(name, age, grade));");
//            students.add(new Student(name, age, grade));
            first = false;
        }else {
            System.out.println("addStudent(new Student(name, age, grade), students.get(students.size()-1));");
//            addStudent(new Student(name, age, grade), students.get(students.size()-1));
        }
      }
  }
}