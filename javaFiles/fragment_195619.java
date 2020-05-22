public void writeFile(Node mainNode, PrintWriter w)
{
    if (mainNode == null)  // base case to stop recursion  
        return;
    top_call = false;  // Flag needed later
    if (w == null) {
        outputStream = new FileOutputStream("BinaryTree.txt");
        w = new PrintWriter(outputStream); 
        top_call = true;  // mark highest entry point to know when to close writer
    }
    writeFile(mainNode.leftChild, w);
    w.print(mainNode);
    writeFile(mainNode.rightChild, w);

    if (top_call)  // don't close writer in recursive calls
        w.close();
}