public static void main(String[] args) throws Exception {
    Node<String> node = new Node<>("1", new Node<>("2", null));
    System.out.println(node); // prints 1 -> 2
    add(node, "3");
    System.out.println(node); // prints 1 -> 2 -> 3
}