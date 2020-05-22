class Node {

  String data;
  Node next, previous;
}

public class SortedDLL {

  private Node first;
  private Node last;
  private int size = 0;

  public SortedDLL() {
    size = 0;
    first = new Node();
    last = new Node();
    first.next = last;
    last.previous = first;
  }

  public void addElement(String element) {
    Node newNode = new Node();
    newNode.data = element;

    if (size == 0) {
      first.next = newNode;
      newNode.previous = first;
      newNode.next = last;
      last.previous = newNode;
    } else {
      Node node = first;
      while (node.next.data != null && node.next.data.compareTo(newNode.data) < 0) {
        node = node.next;
      }
      newNode.next = node.next;
      node.next.previous = newNode;
      node.next = newNode;
      newNode.previous = node;
    }

    size++;
  }

  public void print() {
    Node node = first;
    while (node != null) {
      System.out.print(node.data != null ? node.data + " " : "null ");
      node = node.next;
    }
  }

  public void printReverse() {
    Node node = last;
    while (node != null) {
      System.out.print(node.data != null ? node.data + " " : "null ");
      node = node.previous;
    }

  }

  public static void main(String[] args) {
    SortedDLL sortedDLL = new SortedDLL();
    sortedDLL.addElement("c");
    sortedDLL.addElement("a");
    sortedDLL.addElement("b");
    sortedDLL.addElement("c");

    System.out.println("list: ");
    sortedDLL.print();

    System.out.println("\nlist reverse: ");
    sortedDLL.printReverse();
  }