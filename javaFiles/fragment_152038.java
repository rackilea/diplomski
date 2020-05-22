public void add(T element) {
   if (first == null) {
       first = new Node<T>(element);
       last = first;
   }
   else {
       last.next = new Node<>(element);
       last = last.next;
   }
}