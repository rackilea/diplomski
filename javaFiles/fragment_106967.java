package Week19;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CreatingFiles {
public static void main(String[] args) throws Exception {

    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("textfile.txt")));
    Scanner scanner = new Scanner (System.in);

    for(int i=0; i < 3; i++){

        System.out.println("Please enter a name please");
        String employeeName = scanner.nextLine();

        System.out.println("Please enter a job title");
        String employeeJobTitle = scanner.nextLine();

        System.out.println("Please enter a age");
        while(!scanner.hasNextInt()) {
            scanner.next();
        }
        int employeeAge = scanner.nextInt();

        System.out.println("Please enter a salary");
        while(!scanner.hasNextDouble()) {
            scanner.next();
        }
        Double employeeSalary = scanner.nextDouble();
        scanner.nextLine();

        writer.println("Employee Name: "+ employeeName);
        writer.println("Employee Job Title: "+ employeeJobTitle);
        writer.println("Employee Age: "+ employeeAge);
        writer.println("Employee Salary: "+ employeeSalary);
    }
    writer.close();
    scanner.close();
}