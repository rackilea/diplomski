import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {
  @SuppressWarnings("resource")
  public static void main(String[] args) throws FileNotFoundException {
    Scanner inFile = new Scanner(new FileReader("/ExternalData.txt"));
    Map<String, Employee> employees = new HashMap<>();
    while(inFile.hasNext()) {
      Employee employee = new Employee(inFile.next(), inFile.nextDouble(), inFile.nextDouble()); 
      employees.put(employee.name, employee);
    }
    System.out.println(employees.get("Dave"));
  }
}