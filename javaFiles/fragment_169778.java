// This is how you might create your list.
private List<Integer> myList = new ArrayList<Integer>();

public synchronized void growArray(int id) {
  if( ! cardList.contains(id) ){
    cardList.add(id);
  }
}