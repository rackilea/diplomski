import java.util.Scanner;

public class FtoC{

    static Scanner cin = new Scanner (System.in);

    public static void main(String[] args)
    {
        while(true) {
            char userInput = ' ';
            System.out.print("\nEnter " + "\"F\"" + " or " + "\"f\"" + " for Fahrenheit to Celsius"
                          + "\nEnter " + "\"C\"" + " or " +  "\"c\"" + " for Celsius to Fahrenheit"
                          + "\nEnter something else to quit." +"\n");

             userInput = cin.next().charAt(0);

            if ((userInput == 'F') || (userInput =='f'))
            {print("Enter a temp in Fahrenheit"
                    +"\n I will tell you temp in Celsius" +"\n");
                far2cel();
            }
             else if ((userInput == 'C') || (userInput =='c')) {
                print("Enter a temp in Celsius:"
                +"\n I will tell you temp in fahrenheit" +"\n");
                    cel2far();
            } else {
                print("Terminating the program" + "\n");
                break;
            }
        }
    }

    private static void cel2far() {
        Scanner input = new Scanner(System.in);
        Double celsius = input.nextDouble();
        print(celsius + " celsius is " + ((celsius * 9 / 5.0) + 32)
                + " Fahrenheit");

    }

    private static void far2cel() {
        Scanner input = new Scanner(System.in);

        Double Fahrenheit = input.nextDouble();
        print(Fahrenheit + " Fahrenheit is " + ((Fahrenheit - 32) * (5 / 9.0))
                + " celsius");

    }

    private static void print(String string) {
        System.out.print("\n" + string);
    }
}