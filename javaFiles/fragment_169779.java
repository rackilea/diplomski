// This is how you might create your list.
private Set<Integer> myList = new HashSet<Integer>();

public synchronized void growArray(int id) {
  cardList.add(id);
}