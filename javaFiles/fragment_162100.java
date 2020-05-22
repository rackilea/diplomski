public void preOrderTraverseTreeNonRecursive(){
    Node current = this.root; // Begin bij de root
    Stack<Node> theStack = new Stack<Node>();

    while(!theStack.empty() || current != null){
        if(current != null){
            // only 3 lines of code allowed
            current.visitStap(); // print current Node information
            theStack.push(current); // push current Node on to the stack
            current = current.leftChild; //  set current node to leftChild
        }else{
            // only 2 lines of code allowed
            current = theStack.pop().rightChild; // pop Node from stack and
                                                 // get its rightChild 

        }
    }
}