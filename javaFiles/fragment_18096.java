public static void main(String args[])
{
    Scanner input = new Scanner( System.in );

    int num, den;
    System.out.println ( "Please enter the numerator: " );
    num = input.nextInt();
    System.out.println ( "Please enter the denominator: " );
    den = input.nextInt();
    if (den != 0 ){
    System.out.println ("Decimal is " + convert (num, den));
    }
    else 
    System.out.println ("Cant divide by zero");       

}

public static double convert(int x, int y)
{        
        return ((double)x/y);        
}