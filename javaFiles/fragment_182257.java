class Node<T>{
    T data;// Object data
    Node next;

    Node(T d){
        this.data = d;
        this.next = null;
    }
}
public class LinkedList<T> {
    Node<T> first = null;
    Node<T> last = null;
    // TODO change all your methods to accept value of type T instead of Object
}