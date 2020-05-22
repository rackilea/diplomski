public class Main
{
    public static void main(String[] args)
    {
        final int value;

        value = score("ACGT", "AC");
        System.out.println(value);
    }

    public static int score(final String gene1,
                            final String gene2)
    {
        final char[] a;
        final char[] b;
        final int    s;

        a = gene1.toCharArray();
        b = gene2.toCharArray();
        s = score(a, b, 0, 0);

        return (s);
    }

    private static int score(final char[] a,
                             final char[] b,
                             final int    idxA,
                             final int    idxB)
    {
        final int value;

        // for all calls: a.length == 4 and b.length == 2
        // first call:  idxA == 0 and idxB == 0 - false || false == false
        // second call: idxA == 1 and idxB == 1 - false || false == false
        // third call:  idxA == 2 and idxB == 2 - false || true  == true      
        if(idxA >= a.length || idxB >= b.length)
        {
            // third call: will return 0            
            value = 0;
        }
        // first call:  a[idxA] == A and b[idxB] == A - true
        // second call: a[idxB] == C and b[idxB] == C - true 
        else if(a[idxA] == b[idxB])
        {
            // this is recursion
            // first call:  1 + score(a, b, 1, 1)
            // second call: 1 + score(a, b, 2, 2)

            // after the third call the call stack starts unwinding
            // second call: 1 + 0 == 1
            // first call:  1 + 1 == 2
            value = 1 + score(a, b, idxA + 1, idxB + 1);
        }
        else
        {
            final int x;
            final int y;

            x = score(a, b, idxA + 1, idxB);
            y = score(a, b, idxB,     idxB + 1);
            value = max(x, y);
        }

        // third call:  0
        // second call: 1
        // first call:  2
        return (value);
    }

    // Can you use Math.max(int, int) instad?
    private static int max(final int x, final int y)
    {
        final int value;

        if(x < y)
        {
            value = y;
        }
        else
        {
            value = x;
        }

        return (value);
    }
}