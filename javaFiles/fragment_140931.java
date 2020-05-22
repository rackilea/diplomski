public class Main
{
  public static void main(String[] args)
  {
        long a=2894135;
        long b=3787313;
        long m=4028033;

        long result=modularExponentiation(a,b,m);
        System.out.println(result);
  }

    static long modularExponentiation(long a,long b,long m)
    {
        long result=1;
        while(b>0)
        {
            if(b % 2 ==1)
                result=(result * a)%m;
            a=(a*a)%m;
            b=b/2;
        }
        return result;
    }
}