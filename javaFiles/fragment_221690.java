import java.util.Scanner;

public class Es3 
{
    static Scanner sc = new Scanner(System.in);
    String s = sc.next();
    public static boolean scan(String s)
    {
        int state = 0;
        int i = 0;

        while (state >= 0 && i < s.length()) {
            final char ch = s.charAt(i++);
            switch (state) {
            case 0:
                // Compare the char to the char values of the numbers
                if (ch >= '0' && ch <= '9')
                    state = 1;          
                else
                    state = -1;
                break;

            case 1:  
                // Same here, compare the char to the char values of the numbers
                if (ch >= '0' && ch <= '9')
                    state = 1;
                // Check if the char is capital, as well as lowercase
                else if ((ch >= 'a' && ch <= 'k') || (ch >= 'A' && ch <= 'K'))
                    // Convert the char to an int before performing the calculations
                    if ((Character.getNumericValue(s.charAt(i-1)))%2 == 0)
                        state = 2;
                    else
                        state = -1;
                // Check if the char is capital as well
                else if ((ch >= 'l' && ch <= 'z') || (ch >= 'L' && ch <= 'Z'))
                    // Convert from char to int before calculating
                    if ((Character.getNumericValue(s.charAt(i-1)))%2 == 1)
                        state = 3;
                    else
                        state = -1;
                else
                    state = -1;
                break;

            case 2:
                // Check if the char is capital as well
                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
                    state = 2;
                else
                    state = -1;
                break;

            case 3:
                // Check if the char is capital as well
                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
                    state = 3;
                else 
                    state = -1;
                break;
            }
        }
        System.out.println("State "+state);
        return (state == 2 || state == 3);      
    }

    public static void main(String[] args)
    {
        System.out.println(scan(args[0]) ? "OK" : "NO");
    }
}