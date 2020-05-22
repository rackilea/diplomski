import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class PageInfo
{
    public static void main(String... args)
    throws Exception
    {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe)f.get(null);

        int pageSize = unsafe.pageSize();
        System.out.println("Page size: " + pageSize);
    }
}