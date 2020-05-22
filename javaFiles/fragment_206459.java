package test;

public class Test
{
    static private int i=30;
    static private int  j=20; 
    static private int l=5;

    public static void main(String[] args)
    {
        if (l==5)
        {

            for (; j<=50  ; j+=2)
            {
                System.out.printf("value of j is %d\n",j);
                increamenti_Value ();
            }
            for (; j>=4; j-=2) // i want here the value j to be 20 ... 

            {
                System.out.printf("value of decrement is %d\n",j);
                increamenti_Value ();
            }
        }
    }

    private static void increamenti_Value ()
    {
        for (; i<=50  ; i+=2) {System.out.printf("value of i is %d\n",i);}  
    }

}