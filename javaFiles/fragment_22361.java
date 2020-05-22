public class stackReversal {

private class Node {    
    private String item;
    private Node next;
}

private Node first = null;

public boolean isEmpty() {
    return (first == null);
}

public void push(String s) {
    Node node = new Node();
    node.item = s;
    node.next = first;

    first = node;
}

public String pop() {
    if (first == null)
        throw new RuntimeException("Stack Empty!");
    String result = first.item;
    first = first.next;
    return result;

}

public String popString() {
    String result = "";
    Node current = first;

    while (current != null) {
        result += current.item;
        current = current.next;
    }
    return result;
}

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 * 
 * This method prints the nodes in reerse order
 */
@Override
public String toString() {

    StringBuilder nodes = new StringBuilder();

    Node node = first;

    while (node != null) {
        nodes.append(node.item).append(" -> ");
        node = node.next;
    }

  if(isEmpty()) {
        return "";
    } else {
        return nodes.toString().substring(0, nodes.toString().length() - 4);    
    }
}

public static void main(String[] args) {
    stackReversal s = new stackReversal();
    s.push("1");
    s.push("2");
    s.push("3");
    System.out.println("Strings:" + s);
}