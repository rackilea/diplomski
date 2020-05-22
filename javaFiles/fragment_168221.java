if(trav.getValue().compareTo(value) == 0) {
    trav = next;            
    num++;
  }
  if(next.getValue().compareTo(value) == 0) {
    trav = next.getNext();
    num++;
  }