public void reverse(Node<T> h) { // draw H under first node
  Node<T> d = null
  while (h.next != null) {
     Node<T> t = h.next;  // draw T under box at end of H arrow (remove any previous T)
     h.next = t.next;     // change arrow from H to end where arrow from box above T ends (no arrow for last element)
     t.next = d;          // draw arrow from box above T to box D is under (no arrow for first element)
     d = t;               // draw D under box (remove any previous D)
   }
   h.next = d;            // draw arrow from H to box D is under
}