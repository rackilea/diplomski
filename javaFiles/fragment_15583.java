import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class BigIntegerDigitsPerformance
{
    public static void main(String[] args)
    {
        testListCreation();
    }

    private static void testListCreation()
    {
        long before = 0;
        long after = 0;

        for (int size = 10; size <= 100000; size *= 10)
        {
            BigInteger number = createRandomBigInteger(size);

            before = System.nanoTime();
            List<Integer> resultA = createA(number);
            after = System.nanoTime();
            System.out.printf(Locale.ENGLISH,
                "A: size %8d time %8.2fms result %d\n",
                size, (after-before)/1e6, resultA.get(0));

            before = System.nanoTime();
            List<Integer> resultB = createB(number);
            after = System.nanoTime();
            System.out.printf(Locale.ENGLISH,
                "B: size %8d time %8.2fms result %d\n",
                size, (after-before)/1e6, resultB.get(0));

            before = System.nanoTime();
            List<Integer> resultC = createC(number);
            after = System.nanoTime();
            System.out.printf(Locale.ENGLISH,
                "B: size %8d time %8.2fms result %d\n",
                size, (after-before)/1e6, resultC.get(0));
        }
    }


    private static BigInteger createRandomBigInteger(int size)
    {
        StringBuilder sb = new StringBuilder();
        Random random = new Random(0);
        for (int i=0; i<size; i++)
        {
            sb.append(String.valueOf(random.nextInt(10)));
        }
        return new BigInteger(sb.toString());
    }


    private static List<Integer> createA(BigInteger number)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (number.compareTo(BigInteger.ZERO) == 1)
        {
            list.add((number.mod(BigInteger.TEN)).intValue());
            number = number.divide(BigInteger.TEN);
        }
        return list;
    }

    private static List<Integer> createB(BigInteger number)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (number.compareTo(BigInteger.ZERO) == 1)
        {
            BigInteger next = number.divide(BigInteger.TEN);
            BigInteger diff = number.subtract(next.multiply(BigInteger.TEN));
            list.add(diff.intValue());
            number = next;
        }
        return list;
    }

    private static List<Integer> createC(BigInteger number)
    {
        String s = number.toString();
        ArrayList<Integer> list = new ArrayList<Integer>(s.length());
        for (int i=s.length()-1; i>=0; i--)
        {
            list.add(s.charAt(i) - '0');
        }
        return list;
    }
}