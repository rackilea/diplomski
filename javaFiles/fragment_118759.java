import java.util.ArrayList;
import java.util.List;

public class QuickListRemove
{
    public static void main(String[] args)
    {
         List<String> size = new ArrayList<String>();
         size = deleteAll(size, "value");
    }

     private static <T> List<T> deleteAll(List<T> list, T valueToDelete) 
     {
         List<T> result = new ArrayList<T>(list.size());
         for (T value : list)
         {
             if (!value.equals(valueToDelete))
             {
                 result.add(value);
             }
         }
         return result;
    }
}