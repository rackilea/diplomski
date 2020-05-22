public class Main {
static class NodeInside {
    int data;
    NodeX.Node next;

    NodeInside(int data) {
        this.data = data;
        next = null;
    }
}
public static void main(String[] args) {
    NodeX ll = new NodeX();
    NodeX.Node head = new NodeX.Node(1); // need to put the enclosing class name
    NodeInside nodeInside = new NodeInside(1); // no need to put the enclosing class 
  }
}

class NodeX{
static class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}
}