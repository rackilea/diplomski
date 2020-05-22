import java.util.*;

public class ExtLinkedList<E> extends LinkedList<E>
{

    public ExtLinkedList<E> oddItemsList () 
    {
        ExtLinkedList<E> oddList = new ExtLinkedList<E>();

        //Get the iterator of the current list instead of the new empty list.
        //Otherwise you will iterate over nothing.
        ListIterator<E> itr = listIterator();

        for(int i = 0; itr.hasNext(); i++)
        {
            E element = itr.next();
            if(i % 2 == 1)
            {
                //System.out.print(element);
                oddList.add(element);
            }
        }
        return oddList;
    }
}