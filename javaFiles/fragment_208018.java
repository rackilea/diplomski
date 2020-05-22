import java.util.Scanner;
public class ValidAge{// Change here
    public static void main(String[]args)
    {
        matches();
    }
    public static void matches()
    {
        Scanner scan = new Scanner(System.in);
        int input = 0;// Change here
        do
        {
            input = scan.nextInt();
            if(input >= 0 && input <= 150)
            {
                System.out.println(input);
                System.out.println("Age is valid");
            }
            else
            {
                System.out.println(input);
                System.out.println("Age is NOT valid");// Change here
            }
        }
        while(input > 0 && input < 150);
    }
}