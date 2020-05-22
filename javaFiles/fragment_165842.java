private static void inorderTraversal(int array[], int pos, Node[] nodes) {
    if (pos >= array.length) {
        return;
    }
    inorderTraversal(array, 2 * pos + 1, nodes);
    nodes[Node.count] = new Node(array[pos], Node.count);
    Node.count++;
    inorderTraversal(array, 2 * pos + 2, nodes);
}