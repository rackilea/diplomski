public static void main (String[] args) {
    INode a = new INode(8);
    int data = a.getValue();
    System.out.println(data);

    List l = new List(); // create new List instance
    System.out.println(l.head.getValue()); // get the head from List instance
}