import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
  @SuppressWarnings("resource")
  public static void main(String[] args) throws FileNotFoundException {
    Scanner inFile = new Scanner(new FileReader("ExternalData.txt"));
    List<Employee> employees = new ArrayList<>();
    while(inFile.hasNext()) {
      employees.add(new Employee(inFile.next(), inFile.nextDouble(), inFile.nextDouble()));
    }
    for(Employee employee : employees) {
      System.out.println(employee);
    }
  }
}