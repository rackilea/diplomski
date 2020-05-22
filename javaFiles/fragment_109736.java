public class BinarySearchTree
 {
    Node root;

    public BinarySearchTree()
    {
        root = null;
    }

    public void insert(String key)
    {
        root = insertRec(root, key);
    }

    public Node insertRec(Node root, String key)
    {
        if(root == null)
        {
            root = new Node(key);
            return root;
        }

        if(key.compareTo(root.toString()) == -1)
        {
            root.setLeft(insertRec(root.getLeft(), key));
        }
        else if(key.compareTo(root.toString()) == 1)
        {
            root.setRight(insertRec(root.getRight(), key));
        }

        return root;
    }

    public Node search(String key)
    {
        return root == null ? null : root.getKey(key);
    }

    public void printPostOrder(Node node)
    {
        if(node == null)
            return;

        printPostOrder(root.getLeft());

        printPostOrder(node.getRight());

        System.out.print(node.getKey("") + ", ");
    }

    public void printInOrder(Node node)
    {
        if(node == null)
            return;

        printInOrder(node.getLeft());

        System.out.print(node.getKey("") + ", ");

        printInOrder(node.getRight());
    }

    public void printPreOrder(Node node)
    {
        if(node == null)
            return;

        System.out.print(node.getKey("") + ", ");

        printPreOrder(node.getLeft());

        printPreOrder(node.getRight());
    }

    public void printPostOrder()
    {
        printPostOrder(root);
    }

    public void printInOrder()
    {
        printInOrder(root);
    }

    public void printPreOrder()
    {
        printPreOrder(root);
    }

    public static void main (String args[]){
        BinarySearchTree bs = new BinarySearchTree();
        bs.insert("A");
        bs.search("A");
    }
 }