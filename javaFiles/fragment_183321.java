import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class InArrayWithAsListContains {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int value=0;
        List<Integer> values = new ArrayList<Integer>();

        values.add(16);
        values.add(10);
        values.add(11);
        values.add(14);
        values.add(17);    

        do {
            System.out.println("Enter a number:");
            value = input.nextInt();    
        } while(!values.contains(value)); 
    }
}