public static void print(Node temp) { //irrelevant method by now
   System.out.print(temp); 
}

public class Node<E>{

    private E data;
    private Node next;

    //...

    public String toString() {
       String ouput = "";
       Node node = this;
       while(node.getNext() != null) {
          output +=  node.getData() +", ";
          node = node.getNext();
       }
       return ouput; 
   }
}