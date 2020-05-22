public int indexOf(E e) {
   for (ListIterator<E> it = listIterator(); it.hasNext(); ){
     if (isEqual(e, it.next()))
        return it.previousIndex();}
    // Element not found
    return -1;
 }

// null safe equals check
public boolean isEqual(E e, E next) {
    if (e == null) 
        // when e is null check if next / it.next() is also null
        return next == null;
    else 
        // else compare left and right
        return e.equals(next);

}