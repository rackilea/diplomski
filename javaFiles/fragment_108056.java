//Get an iterator on your list.
Iterator<Map<String, String>> itr = list.iterator();

//iterate
while(itr.hasNext()) {
  Map<String, String> elt= itr.next();
  if(isDuplicate(list, elt)) {
    itr.remove();
  }
}