import java.util.*;

public class Player{
    public static void main (String [] args){

        Scanner getInput = new Scanner(System.in);
        System.out.print("Input a number");
        //you can take input as integer if you want integer value by nextInt()
        String number = getInput.nextLine();

        ExampleClass obj = new ExampleClass(number);
        obj.checkMethod();
    }
}