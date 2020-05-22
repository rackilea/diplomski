import java.util.*;

public class MapTest
{
    public static final void main(String[] args)
    {
        Map map;

        try
        {
            map = Collections.synchronizedMap(new HashMap());
            map.put("one", "a");
            System.out.println("Size = " + map.size());
            map.put(null, "b");
            System.out.println("Size = " + map.size());
            System.out.println("map.get(null) = " + map.get(null));
        }
        catch (Exception ex)
        {
            System.out.println("Exception: " + ex.getMessage());
            ex.printStackTrace(System.out);
        }
        System.exit(0);
    }
}