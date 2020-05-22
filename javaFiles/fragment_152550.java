package javaapplication6;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class JavaApplication6 {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of lines :");
        int num = input.nextInt();
        String output = "";
        int width= num*2-1+num*2;
        for(int i = 1; i <= num; i++){
            System.out.println(width/2-(i-1)*2);
            for (int j = 0;j<width/2-(i-1)*2;j++){
                System.out.print(" ");
            }
            output = i != 1 ? i + " " + output + " " + i : "1";
            System.out.println(output);
        }
   }
}