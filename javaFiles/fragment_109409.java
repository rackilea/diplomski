private ListIterator<T> itor; // Not just Iterator<T>; you need the add method

public void insert(T element)
{
    itor.add(element);
}