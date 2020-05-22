import java.io.*;
import java.util.Scanner;

public class Ex2 {
public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("people.txt"));
    // to get number of people
    int count=0;
    //to get total age
    double totalAge=0;
    while (input.hasNext()) 
    {
        String[] line = input.nextLine().replace(",", "").split("\\s+");
        String age = line[0];
        String lastName = line[1];
        String firstName = "";
        //take the rest of the input and add it to the last name
        for(int i = 2; 2 < line.length && i < line.length; i++)
            firstName += line[i] + " ";

        //Convert age string into double and add it to totalAge
        totalAge=totalAge+Double.parseDouble(age);
        System.out.println(++count+" "+firstName + lastName + " " + age);
    }
    double average = totalAge / count;
    System.out.println("The average age is: " + average);
}
}