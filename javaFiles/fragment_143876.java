import java.util.*;

public class Test
{    
    public static void main(String[] args)
    {
        TimeZone tz = TimeZone.getTimeZone("Europe/Paris");
        System.out.println(tz.getDisplayName());
    }
}