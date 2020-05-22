import java.util.Scanner;
public class HelloWorld{

     public static void main(String []args){
          changeToFahrenheit();
     }

    public static double changeToFahrenheit(){

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a number between 0-20: ");
        double celsius = reader.nextInt();
        double fahrenheit = (9/5) * celsius +32;

        System.out.println(fahrenheit);
        return fahrenheit;
    }
}