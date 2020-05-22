import java.util.Scanner;

public class VerticalText {

    public static void main(String[] args) {

        Scanner Read = new Scanner(System.in);
        System.out.println("Insert a number from 1 to 100: ");
        int start = Read.nextInt();
        System.out.println("Insert another number from 1 to 100: ");
        int end = Read.nextInt();

        String numbers = "";

        for(int i = start; i <= end; i++)
        {
            if(i < 10)
            {
                numbers += String.format("%02d", i);
            }
            else
            {
                numbers += i;
            }
        }

        for(int i = (end-1); i >= start; i--)
        {
            if(i < 10)
            {
                numbers += String.format("%02d", i);
            }
            else
            {
                numbers += i;
            }
        }

        String row1 = "";
        String row2 = "";

        char[] chars = numbers.toCharArray();

        for(int i = 0; i < chars.length; i++)
        {
            if(chars[i] == '0')
            {
                chars[i] = ' ';
            }
            row1 += chars[i];
            i++;
            row2 += chars[i];
        }

        System.out.println(row1);
        System.out.println(row2);
    }
}