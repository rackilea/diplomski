public iterator search(T data)
{
    no<T> temp = first;
    while (!data.equals(temp.data)) {
        temp = temp.next;
    }
    return (new iterator(temp));
}