public ListIterator<E> listIterator(final int index) {
if (index<0 || index>size())
  throw new IndexOutOfBoundsException("Index: "+index);

return new ListItr(index);
}