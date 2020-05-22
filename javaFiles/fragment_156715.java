import java.lang.*;
import java.util.*;
public class CheckEqual{

    public static void main(String [] args){
        if (args.length != 5){
            System.out.println("Please check the number of your integers!");
            return;
        }
        try{
            int firstInteger = Integer.parseInt(args[2]);
            int secondInteger = Integer.parseInt(args[3]);
            int thirdInteger = Integer.parseInt(args[4]);

            if (firstInteger == secondInteger && secondInteger == thirdInteger){
                System.out.println("True");
                return;
            }
            else{
                System.out.println("False");
                return;
            }
        }
        catch(NumberFormatException e){
            System.out.println("Make sure that all inputs are integers!");
            return;
        }
    }
}