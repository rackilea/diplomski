private class Node {
  Item item;
  Node next;
  private Node(Item item, Node next) {
    if (item == null) throw new NullPointerException();
// 'this' refers to the created instance and helps distinguish the field from the param
    this.item = item;  
    this.next = next;
  }
}

public void addFirst(Item item) {
  // creates a new Node before first so to speak and then repoints first to this node 
  first = new Node(item, first);   
  if (num_elements==0) last = first;
  num_elements++;
}

public void addLast(Item item) {
  if (num_elements == 0) {  
    // this will deal with the case (last==null) which causes the NPE
    addFirst(item);
    return;
  }
  last.next = new Node(item, null);
  last = last.next;
  num_elements++;
}