public int indexOf(E e) {
  for (ListIterator<E> it = listIterator(); it.hasNext(); ){
     if (foo(e, it.next())
        return it.previousIndex();}
 // Element not found
return -1;
}


public boolean foo(E e, E next) {
  // in the first step we take the expression as it is
  return e == null ? next == null : e.equals(next);
}