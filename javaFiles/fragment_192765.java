public class LinkedList<T> {

    private Node<T> head;
    private Node<T> nextNode;
    private int size = 0;

    public void addFirst(T element){
        head = new Node<T>(element, head);
    }

    public void add(T element){
        if(head == null)
            addFirst(element);
        else{
            Node<T> node = head;
            while(node.next != null){
                node = node.next;
            }
            node.next = new Node<T>(element, null);
        }
        size++;
    }

    public int size(){
        return size;
    }

// Inner class somewhere here
}