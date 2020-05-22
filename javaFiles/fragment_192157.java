import java.util.*;
import java.text.*;

public class Test
{
    public static void main(String[] args)
    {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(format.format(calendar.getTime()));
    }
}