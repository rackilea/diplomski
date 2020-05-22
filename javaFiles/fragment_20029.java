public class Node {
private int value;
private Node next;
private String address=getClass().getName() + "@" + Integer.toHexString(hashCode());

public String getAddress() {
    return this.address;
}

Node(int value){
    this.value=value;
}

public int getValue() {
    return value;
}

public void setValue(int value) {
    this.value = value;
}

public Node getNext() {
    return next;
}

public void setNext(Node next) {
    this.next = next;
}

public String toString(){
    return "value = " +  this.value + ", next = " + getNextAddress();
}

private String getNextAddress() {
    if(getNext()==null){
        return "null";
    }
    return getNext().getAddress();
}


public static void main(String[] args) {
    System.out.println("Begin TestMain \n");

    Node head = new Node(10);
    Node n1 = new Node(11);
    Node n2 = new Node(12);
    Node n3 = new Node(13);

    head.setNext(n1);
    n1.setNext(n2);
    n2.setNext(n3);

    System.out.println("Head : " + head);
    System.out.println("n1 : " + n1);
    System.out.println("n2 : " + n2);
    System.out.println("n3 : " + n3);

    System.out.println("\nEnd TestMain");

}}