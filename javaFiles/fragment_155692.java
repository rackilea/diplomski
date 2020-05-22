import java.util.List;
public class LinearSearch<E>
{
public int linear (E[] contents, E query)
{
    for (int index = 0; index < contents.length; ++index)
    {
        if (query.equals(contents[index]))
        {
            return index;
        }
     }
     return -1;
}

public int linear (List<E> contents, E query)
{
    for (int index = 0; index < contents.size(); ++index)
    {
        if (query.equals(contents.get(index)))
        {
            return index;
        }
     }
     return -1;
}
}