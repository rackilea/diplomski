import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

  private static String nextLine(Scanner sc) {
    String line;
    while (sc.hasNext()) {
      if (!(line = sc.nextLine()).isEmpty()) {
        return line;
      }
    }
    return null;
  }

  public static ArrayList<Student>[] parseFile(String fileName) {
    File file = new File(fileName);
    try (Scanner sc = new Scanner(file)) {
      int numClasses = sc.nextInt();
      String className = nextLine(sc);
      ArrayList<Student>[] classList = new ArrayList[numClasses];
      for (int i = 0; i < numClasses; i++) {
        classList[i] = new ArrayList<>();
        while (true) {
          String studentOrClassName = nextLine(sc);
          if (studentOrClassName == null) {
            break;
          }
          String dateOrBlankLine = sc.nextLine();
          if (dateOrBlankLine.isEmpty()) {
            className = studentOrClassName;
            break;
          }
          int timeSpent = sc.nextInt(); 
          int videosWatched = sc.nextInt();
          classList[i].add(new Student(className, dateOrBlankLine, studentOrClassName, timeSpent, 
              videosWatched));
        }
      }
      return classList;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return new ArrayList[0];
  }

  public static void main(String[] args) {
    for (ArrayList<Student> students : parseFile("classList.txt")) {
      if (!students.isEmpty()) {
        System.out.println(students.get(0).className);
      }
      for (Student student : students) {
        System.out.println(student);
      }
    }
  }

  static class Student {

    public String className;
    public String date;
    public String name;
    public int timeSpent;
    public int videosWatched;


    public Student(String className, String date, String name, int timeSpent,
        int videosWatched) {
      this.className = className;
      this.date = date;
      this.name = name;
      this.timeSpent = timeSpent;
      this.videosWatched = videosWatched;
    }

    public String toString() {
      return name + '\n' + date + '\n' + timeSpent + '\n' + videosWatched + '\n';
    }
  }
}