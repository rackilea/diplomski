/**
 * Returns the index of the last occurrence of the specified element in this list,
 * or -1 if this list does not contain the element. More formally, returns the highest
 * index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
 * @param item
 * @return the index of the last occurrence of the specified element in this list, 
 * or -1 if this list does not contain the element
 */
public int lastIndexOf(E item) {
    int index = -1;
    Node<E> temp = head;
    for(int i=0; i < size; i++){
        if(temp.data.equals(item))
            index = i;
        temp = temp.next;
    }
    return index;
}