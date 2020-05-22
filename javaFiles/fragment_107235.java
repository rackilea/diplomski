import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentTest {
   private static final String DATA_FILE_PATH = "myFile.dat";

   public static void main(String[] args) {
      Student[] students = {new Student("John", "Smith"),
            new Student("Mike", "Barnes"),
            new Student("Mickey", "Mouse"),
            new Student("Donald", "Duck")};

      // create our collection object
      StudentCollection studentColl1 = new StudentCollection();

      // print out that it currently is empty
      System.out.println("studentColl1: " + studentColl1);

      // Add Student objects to it
      for (Student student : students) {
         studentColl1.addStudent(student);
      }

      // show that it is now full
      System.out.println("studentColl1: " + studentColl1);

      // create a file
      File myFile = new File(DATA_FILE_PATH);

      // write out our collection to file on disk
      studentColl1.writeToFile(myFile);

      // create another collection object 
      StudentCollection studentColl2 = new StudentCollection();

      // show that it is empty
      System.out.println("studentColl2: " + studentColl2);

      // read the list back into the new StudentCollection object
      File myFile2 = new File(DATA_FILE_PATH);
      studentColl2.readFromFile(myFile2);

      // add a few more Student's:
      studentColl2.addStudent(new Student("Stack", "Overflow"));
      studentColl2.addStudent(new Student("Donald", "Trump"));

      // show the result
      System.out.println("studentColl2: " + studentColl2);
   }
}