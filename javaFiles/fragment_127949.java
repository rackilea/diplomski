import java.math.BigInteger;

public class Problem7
{
    public static void main(String[]args)
    {
        int i = 0;
        int counter = 0;

        while(true)
        {

            if(i>6)
            {
                break;
            }

            if(i>1)
            {
                String str = String.valueOf(i);

                if (new BigInteger(str).isProbablePrime(i/2))
                {
                    System.out.println(str);
                     counter++;
                }
            }
            i++;

        }

    }
}