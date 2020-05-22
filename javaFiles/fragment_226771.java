Node root = new Node(x);
// root == Node(x);

doSomething(root);
// Pass Node(x) into function;

void doSomething(Node node) {
    // root == Node(x);
    // node == Node(x); 

    node = new Node(y); // This updates node but not root
    // root == Node(x);
    // node == Node(y);

}