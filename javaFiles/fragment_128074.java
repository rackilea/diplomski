import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class ReversedListViewTest
{
    public static void main(String[] args)
    {
        String[] array = {"Apple","Orange","Mango","Kiwi","Banana"};

        List<String> list = Arrays.asList(array);
        System.out.println("List         : "+list);

        List<String> reversedView = reversedView(list);
        System.out.println("Reversed view: "+reversedView);
    }

    private static <T> List<T> reversedView(final List<T> list)
    {
        return new AbstractList<T>()
        {
            @Override
            public T get(int index)
            {
                return list.get(list.size()-1-index);
            }

            @Override
            public int size()
            {
                return list.size();
            }
        };
    }

}