import java.util.Scanner;

public class HelloWorld{

    public static void main(String[] args) {

        Scanner kbd = new Scanner(System.in);
        System.out.println("This program fills an array of doubles using an"
                + " initial value, the array size and an increment value.");
        System.out.println("Please enter the desired size of the array: ");

        int size = kbd.nextInt();
        double[] array1 = new double[size];

        System.out.println("Please enter the value of the first element: ");                     
        array1[0] = kbd.nextDouble(); 
        System.out.println("Please enter the increment value: ");

        double inc=kbd.nextDouble();
        double total=array1[0];

        /* remove this line to use method 1 --
        System.out.println(array1[0]);
        for (int i =1; i < array1.length;i++){
            array1[i] = (total = total + inc);
            System.out.println(array1[i]);
        } 
        -- remove this line to use method one */

        // Method two is below.
        System.out.println(array1[0]);
        for (int i =1; i < array1.length;i++){
            array1[i] = array1[i - 1] + inc;
            System.out.println(array1[i]);
        }
    }
}