import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapLoop
{
    public static void main(String[] args) throws Exception
    {
        runTestInfinite();
        runTestFinite();
    }

    private static void runTestInfinite() throws Exception
    {
        System.out.println("Running test with inifinite loop");

        Map<Long, Long> map = new ConcurrentHashMap<>();
        map.put(0L, 0L);
        map.put((1L << 32) + 1, 0L);

        int counter = 0;
        for (long key : map.keySet())
        {
            map.put(key, map.remove(key));

            System.out.println("Infinite, counter is "+counter);
            printTable(map);

            counter++;
            if (counter == 10)
            {
                System.out.println("Bailing out...");
                break;
            }
        }

        System.out.println("Running test with inifinite loop DONE");
    }

    private static void runTestFinite() throws Exception
    {
        System.out.println("Running test with finite loop");

        Map<Long, Long> map = new ConcurrentHashMap<>();
        map.put(0L, 0L);
        map.put(1L, 0L);

        int counter = 0;
        for (long key : map.keySet())
        {
            map.put(key, map.remove(key));

            System.out.println("Finite, counter is "+counter);
            printTable(map);

            counter++;
        }

        System.out.println("Running test with finite loop DONE");
    }


    private static void printTable(Map<Long, Long> map) throws Exception
    {
        // Hack, to illustrate the issue here:
        System.out.println("Table now: ");
        Field fTable = ConcurrentHashMap.class.getDeclaredField("table");
        fTable.setAccessible(true);
        Object t = fTable.get(map);
        int n = Array.getLength(t);
        for (int i = 0; i < n; i++)
        {
            Object node = Array.get(t, i);
            printNode(i, node);
        }
    }

    private static void printNode(int index, Object node) throws Exception
    {
        if (node == null)
        {
            System.out.println("at " + index + ": null");
            return;
        }
        // Hack, to illustrate the issue here:
        Class<?> c =
            Class.forName("java.util.concurrent.ConcurrentHashMap$Node");
        Field fHash = c.getDeclaredField("hash");
        fHash.setAccessible(true);
        Field fKey = c.getDeclaredField("key");
        fKey.setAccessible(true);
        Field fVal = c.getDeclaredField("val");
        fVal.setAccessible(true);
        Field fNext = c.getDeclaredField("next");
        fNext.setAccessible(true);

        System.out.println("  at " + index + ":");
        System.out.println("    hash " + fHash.getInt(node));
        System.out.println("    key  " + fKey.get(node));
        System.out.println("    val  " + fVal.get(node));
        System.out.println("    next " + fNext.get(node));
    }
}