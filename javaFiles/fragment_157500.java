public SortedLinkedList<T> makeUnion( SortedLinkedList<T> other)
{
    LinkedList<T> temp = new LinkedList<T>();
    temp.addAll(this);
    temp.addAll(other);
    SortedLinkedList<T> merge = new SortedLinkedList(temp);
    return merge;
}