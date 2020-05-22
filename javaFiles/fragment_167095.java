import java.util.Scanner;  <-------- import the class

public class InputFromUser { 

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);    
        System.out.println("Enter a number for the array size:");
        int size = scan.nextInt();    
        int[] arr = new int[size];

    }

}