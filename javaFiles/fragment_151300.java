public void add(int value) {
    // you always printed out the value of the root node with every call to this method
    // I updated it to reflect the input argument
    System.out.println("\nvalue is " + value);
    root = addRecursive(root, value);
}