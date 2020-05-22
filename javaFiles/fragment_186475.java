import java.util.InputMismatchException;
import java.util.Scanner;

//Program that does quadratic equations with exceptions                                                                

public class Quadratic{

    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    double a = 0.0 ;
    boolean valid_a = false;
    while(!valid_a){
            try{
                System.out.print("Enter a value for 'a': ");
                a = sc.nextDouble();

                if (a==0){
                    System.out.println("value can not be equal to 0. Please enter another value:");
                }
                else{
                    valid_a = true;
                }
            }
            catch (InputMismatchException ex){
                System.out.println(ex);
                sc.next();
                System.out.println("not a valid character..");
                System.out.println("please try again:");
            }
        }
    }
}