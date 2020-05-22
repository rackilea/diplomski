import java.util.Scanner;
public class Somethin
{
    //Declare data fields
    //Outside of every method to prevent creating local variables
    private static double a1,b1,a2,b2;
    public static void main(String[] args)
    {
        //setRead() method call
        setRead();
        //checkLines() method call
        checkLines();

    }
    public static void setRead()
    {
        //This method ask the user for input
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter a1: ");
        a1 = scan.nextDouble();
         System.out.print("Please enter b1:  ");
             b1 = scan.nextDouble();

            System.out.print("Please enter a2:  ");
             a2  = scan.nextDouble();

            System.out.print("Please enter b2:  ");
             b2 = scan.nextDouble();
    }
    public static Double getA1()
    {
        //get method return a double value not void
        return a1;

    }
    public static Double getB1()
    {
        //get method return a double value not void
        return b1;

    }
    public static Double getA2()
    {
        //get method return a double value not void
        return a2;

    }
    public static Double getB2()
    {
        //get method return a double value not void
        return b2;

    }
    public static void checkLines()
    {
        //This method display the inputted values
        if(getA1()==getA2())
        {
            System.out.println("Line 1 and Line 2 are parallel");
        }
        if(getA1()*getA2()==-1)
        {
            System.out.println("Line 1 and Line 2 are perpendicular"); 
            } 
        else 
        {
                System.out.println(" The lines are intersecting");  
                System.out.println(" There points of intersection are");
                double x = ((getB2() - getB1())/(getA2()-getA1()));
                double y = (getA1()*(x) + getB1());
                System.out.println(" X = " +x);
                System.out.println(" y = " + y);

            }


    }



}