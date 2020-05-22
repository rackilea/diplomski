public class Loops
{   
    public static void main ( String[] args )
    {
        int oddNumber = 1;
        int totalOdd = 0;
        int evenNumber = 2;
        int totalEven = 0;

        while ( oddNumber <= 25 )
        {
            totalOdd = totalOdd + oddNumber;
            oddNumber = oddNumber + 2;      
        }       
        System.out.printf ( "Total sum of the odd number is %d\n", totalOdd);

        while (evenNumber <= 50)
        {
            totalEven = totalEven + evenNumber;
            evenNumber = evenNumber + 2;
        }
      System.out.printf ( "Total sum of the even number is %d\n", totalEven);
    }
}