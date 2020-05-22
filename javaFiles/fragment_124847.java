import java.util.Scanner;

class Main {
    private static Scanner inp;
    public static void main(String[] args)
    {
        inp = new Scanner(System.in);
        System.out.print("Input Password: ");
        int n = inp.nextInt(); // For int
        System.out.println(n);

        if(n != 234)
        {
            System.out.println("Denied Access");
        }
        else
        {
            System.out.println("Password Accepted");
        }

        /* Scanner has already been initialized, don't create 
           a new one, use existing one, don't try and print the 
           Scanner because it is of type Scanner. */


        System.out.print("Input Text to encrypt: ");
        String m = inp.next(); // For String
        System.out.println(m);
    }
}