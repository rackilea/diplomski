import java.util.*;
import java.lang.*;

class Main
{
    private static void test (String regex, String replace, int repetitions)
    {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < repetitions; i++)
        {
            String str = "30-Nov-2012 United Kingdom, 31-Oct-2012 31-Oct-2012 United Arab Emirates, 29-Oct-2012 31-Oct-2012 India, ";
            str.replaceAll(regex, replace);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + Long.toString(endTime - startTime));
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        test("(\\d{4})\\s", "$1@", 10000);
        test("(?<=\\d{4})\\s", "@", 10000);
        test("(\\d{4})\\s", "$1@", 10000);
        test("(?<=\\d{4})\\s", "@", 10000);
        test("(\\d{4})\\s", "$1@", 10000);
        test("(?<=\\d{4})\\s", "@", 10000);
        test("(\\d{4})\\s", "$1@", 10000);
        test("(?<=\\d{4})\\s", "@", 10000);
    }
}