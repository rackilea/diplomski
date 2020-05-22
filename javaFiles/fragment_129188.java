import java.util.*;
public class Main
{

    public static void main (String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int [] ISBN = new int [10];
        int input =0;
        String fullIsbn;

        System.out.print("Give me 10 numbers: ");

        for (int i = 0; i<ISBN.length;i++){
            int nextNumber = keyboard.nextInt();
            ISBN[i] = nextNumber;
            ++input;

            if (input==10){
                ISBN[0]=0;
                ISBN[9] = (ISBN[0] * 1 + ISBN[1] * 2 + ISBN[2] * 3 + ISBN[3] * 4 + ISBN[4] * 5 + ISBN[5] * 6 + ISBN[6] * 7 + ISBN[7] * 8 + ISBN[8] * 9) % 11;
                if (ISBN[9] == 10)
                {

                    fullIsbn = ISBN[0] + "" + ISBN[1] + "" + ISBN[2] + "" + ISBN[3] + "" + ISBN[4] + "" + ISBN[5] + "" + ISBN[6] + "" + ISBN[7] + "" + ISBN[8] + "" + "X";
                }
                else  // Determines if num10 is equal to x or not and prints
                {
                    fullIsbn = ISBN[0] + "" + ISBN[1] + "" + ISBN[2] + "" + ISBN[3] + "" + ISBN[4] + "" + ISBN[5] + "" + ISBN[6] + "" + ISBN[7] + "" + ISBN[8] + "" + ISBN[9];

                }
                System.out.print("The tenth number you gave me is: "+fullIsbn);
            }
        }

    }
}