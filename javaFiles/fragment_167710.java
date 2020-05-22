import java.util.Scanner;

public class RPNCalc 
{
    public static void main(String[]args)
    {
        Scanner keyboard = new Scanner(System.in);

        double v1, v2;
//        String operator = keyboard.nextLine();
//        char symbol = operator.charAt(0);
        char operator = ' ';//First time around, set this to an something other than 'q'
        String operatorString = " ";
        System.out.print("Enter a value v1: ");
        v1 = keyboard.nextDouble();
        System.out.println();
        while(operator != 'q')
        {
            System.out.print("Enter a value v2: ");
            v2 = keyboard.nextDouble();
            System.out.println();
            System.out.print("Enter one of the valid operators +, -, *, /, nCr,:  ");
            operatorString = keyboard.next();//nextLine() doesn't wait until the user hit enter
            operator = operatorString.charAt(0);
            switch (operator)
            {
             case'+':
                v1 = sum(v1, v2);
                System.out.println(v1);
                break;
             case'-':
                v1 = minus(v1, v2);
                System.out.println(v1);
                break;
             case'*':
                v1 = times(v1, v2);
                System.out.println(v1);
                break;
             case'/':
                v1 = divide(v1, v2);
                System.out.println(v1);
                break;
             case'q':
                System.out.println("Your last result was "  );                
             default:
                System.out.println("You must choose an appropriate operator .");
             }
        }
    }

    double value1, value2;
    int n;

    public static double sum(double value1,double value2)
    {
        double newSum = value1 + value2;
        return newSum;
    }
    public static double minus(double value1, double value2)
    {
        double newMinus = value1 - value2;
        return newMinus;
    }
    public static double times(double value1, double value2)
    {
        double newTimes = value1 * value2;
        return newTimes;
    }

    public static double divide(double value1, double value2)
    {
        if (value2 == 0)
        {
            System.out.println("Division by Zero. Try again");
            return value1;
        }
        double newDivide = value1 / value2;
        return newDivide;
    }
}