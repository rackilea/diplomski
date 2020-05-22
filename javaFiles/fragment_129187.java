import java.util.Scanner;
public class Main
{

    public static void main (String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int [] ISBN = new int [10];
        int input =0;

        System.out.print("Give me 10 numbers: ");

        for (int i = 0; i<ISBN.length;i++){
            int nextNumber = keyboard.nextInt();
            ISBN[i] = nextNumber;
            ++input;

            if (input==10){
                System.out.print("The tenth number you gave me is: "+ISBN[9]);
            }
        }

    } 
}