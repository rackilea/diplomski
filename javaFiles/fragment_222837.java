class DigitMath
{
    private static double countDigits( int number )
    {
        double count = 0.0;
        while( number > 0 )
        {
            count++;
            number = number / 10;
        }
        return count;
    }
    private static double sumDigits( int number )
        {
            double total = 0;
            while( number > 0 )
            {
                total = total + number % 10;
                number = number / 10;
            }
            return total;
        }


    public static double averageDigits( int number )
        {
            if( number > 0 ){
                return sumDigits( number ) / countDigits( number );
            }
          return 0.0;
        }
}



public class Lab09e
{
    public static void main( String args[] )
    {
        System.out.println(DigitMath.averageDigits(234));
    }
}