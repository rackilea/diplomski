public class Test
{  
    static class Node {
        public int value, countOfSmaller, sizeOfSubtree;
        public Node left, right;
        public Node(int val, int count) {
            value = val;
            countOfSmaller = count;
            sizeOfSubtree = 1; /** You always add a new node as a leaf */
            System.out.println("For element " + val + " the number of smaller elements to the right is " + count);
        }
    }
    static Node insert(Node node, int value, int countOfSmaller)
    {
        if (node == null)
            return new Node(value, countOfSmaller);

        if (value > node.value)
            node.right = insert(node.right, value, countOfSmaller + size(node.left) + 1);
        else
            node.left = insert(node.left, value, countOfSmaller);

        node.sizeOfSubtree = size(node.left) + size(node.right) + 1;

        /** Here goes the rebalancing part. In case that you plan to use AVL, you will need an additional variable that will keep the height of the subtree.
            In case of red-black tree, you will need an additional variable that will indicate whether the node is red or black */

       return node;
    }
    static int size(Node n)
    {
        return n == null ? 0 : n.sizeOfSubtree;
    }

    public static void main(String[] args)
    {    
        int[] array = {13, 8, 4, 7, 1, 11};
        Node root = insert(null, array[array.length - 1], 0);
        for(int i = array.length - 2; i >= 0; i--)      
           insert(root, array[i], 0); /** When you introduce rebalancing, this should be root = insert(root, array[i], 0); */
    }
}