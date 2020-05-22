<T> T getElementOrNull( List<T> list, int index ) {
  if( list == null || index < 0 || index >= list.size() ) {
    return null;
  }      

  return list.get( index );
}