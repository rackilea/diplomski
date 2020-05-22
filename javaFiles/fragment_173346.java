import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator10 {

    public static void main(String[] args) {

        Scanner user_input = new Scanner(System.in);

        int num;

        do {
            System.out.print("Enter a number: ");
            num = user_input.nextInt();
        } while(num % 10 != 0);

        double numb;
        double sum=0;
        DecimalFormat dec = new DecimalFormat("0.00");
        for (int i=0; i<num; i++){
            numb = Math.random() * ( 100 - 0));
            System.out.print(" " + dec.format(numb) + " ");
            sum += numb;
        }

        System.out.println("The sum is: " + dec.format(sum));
        System.out.println("The average is:" + dec.format(sum/num));
    }
}