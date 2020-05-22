public void traverse(){
  Node<T> pointer = head;

  while (pointer != null){
    System.out.println(pointer.getData());
    pointer = pointer.getLink();
  }
}