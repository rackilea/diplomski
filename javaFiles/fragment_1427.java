import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main
{
    public static void main(final String[] argv)
    {
        final List<Integer> list;

        list = new ArrayList<Integer>();

        for(int i = 10; i > 0; i--)
        {
            list.add(i);
        }

        Collections.sort(list, new DefaultAtStartComparator<Integer>(5));

        System.out.println(list);
    }
}

class DefaultAtStartComparator<T extends Comparable>
    implements Comparator<T>
{
    private final T defaultValue;

    public DefaultAtStartComparator(final T value)
    {
        defaultValue = value;
    }

    public int compare(final T a,
                       final T b)
    {
        if(a.equals(defaultValue))
        {
            return (-1);
        }

        if(b.equals(defaultValue))
        {
            return (1);
        }

        return (a.compareTo(b));
    }
}