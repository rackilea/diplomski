class Node {
    Object data;
    Node next;
    Node(Object d,Node n) {
        data = d ;
        next = n ;
       }

   public static Node addLast(Node header, Object x) {
       // save the reference to the header so we can return it.
       Node ret = header;

       // check base case, header is null.
       if (header == null) {
           return new Node(x, null);
       }

       // loop until we find the end of the list
       while ((header.next != null)) {
           header = header.next;
       }

       // set the new node to the Object x, next will be null.
       header.next = new Node(x, null);
       return ret;
   }
}