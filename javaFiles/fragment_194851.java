public class LinkedStack<T> {

  private int size;
  private StudentNode<T> head;
  /* methods */
  public boolean pop()  
  { 
    if (this.size > 0) {
      this.head = this.head.getNext();
      this.size--;
      return true;
    } else {
      return false;
    }
  }
}