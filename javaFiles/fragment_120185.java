import java.util.*;
import java.io.*;

public class loopingSalaryTotal {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("salaries1.txt"));
        int items = 0;
        double total = 0;

        while (scan.hasNextInt()) {
            // add the next salary to the total
            total += scan.nextInt();
            // increase the number of encountered salaries by 1
            items++;
        }
        double average = total/items;
        System.out.println("average:" + average);

        scan.close();
    }
}