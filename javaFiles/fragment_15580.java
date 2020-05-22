import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class BigIntegerDigitsPerformanceLists
{
    public static void main(String[] args)
    {
        testListConversion();
    }

    private static void testListConversion()
    {
        long before = 0;
        long after = 0;

        for (int size = 10; size <= 1000000; size *= 10)
        {
            List<Integer> inputA = createRandomList(size);
            List<Integer> inputB = createRandomList(size);

            before = System.nanoTime();
            List<Integer> resultA = convertA(inputA);
            after = System.nanoTime();
            System.out.printf(Locale.ENGLISH,
                "A: size %8d time %8.2fms result %d\n",
                size, (after-before)/1e6, resultA.get(0));

            before = System.nanoTime();
            List<Integer> resultB = convertB(inputB);
            after = System.nanoTime();
            System.out.printf(Locale.ENGLISH,
                "B: size %8d time %8.2fms result %d\n",
                size, (after-before)/1e6, resultB.get(0));
        }
    }

    private static List<Integer> createRandomList(int size)
    {
        List<Integer> result = new ArrayList<Integer>();
        Random random = new Random(0);
        for (int i=0; i<size; i++)
        {
            result.add(random.nextInt(10));
        }
        return result;
    }


    private static List<Integer> convertA(List<Integer> list)
    {
        List<Integer> result = new ArrayList<Integer>();
        Collections.reverse(list);
        while (!list.isEmpty())
        {
            result.add(list.get(0));
            list.remove(0);
        }
        return result;
    }

    private static List<Integer> convertB(List<Integer> list)
    {
        List<Integer> result = new ArrayList<Integer>();
        while (!list.isEmpty())
        {
            result.add(list.get(list.size() - 1));
            list.remove(list.get(list.size() - 1));
        }
        return result;
    }
}