public class prime
{
    public static boolean isPrime (int num) {
        int t = 2;
        while (t * t <= num) {
            if ((num % t) == 0) {
                return false;
            }
            t++;
        }
        return true;
    }


    public static void main (String[] arg) 
    {
        System.out.println (isPrime (7)) ; 
    }
}