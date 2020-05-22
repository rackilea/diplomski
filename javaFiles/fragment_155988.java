public class BinaryTree {

    // Tree: simplest possible binary search tree
    private Node root; // hidden root node

    // inorderTraversal: need because root is hidden
    public void inorderTraversal(PrintWriter writer) {
        inorderT(root, writer);
    }

    // inorderT: recursive function that does the work
    private void inorderT(Node node, PrintWriter writer) {
        if (node != null) {
            inorderT(node.left, writer);
            System.out.println(node.data+" ");
            //node.data = node.data+" ";
            writer.println(node.data+" ");    // Here, write to the file.
            inorderT(node.right, writer);
    }
}
public static void main(String ... args) throws IOException {

        System.out.println("Starting");
        File file = new File("C:\\Users\\Marlene\\Workspace\\BinaryTree\\src\\com\\company\\unsorteddict.txt");
        Scanner scan = new Scanner(file);

        //Creation of linked list and line variable
        String fileContents = "";
        LinkedList<String> linkedList = new LinkedList<>();
        BinaryTree tree = new BinaryTree();
        int lineNum = 0;

        //Writing contents into a file
        PrintWriter writer = new PrintWriter("C:\\Users\\Marlene\\Workspace\\BinaryTree\\src\\com\\company\\sorteddict.txt", "UTF-8");

        while(scan.hasNextLine()){
            fileContents = scan.nextLine();
            lineNum++;
            int x = 0;
            if (linkedList.size() == 0) {
                linkedList.add(0, fileContents);
            }
            else {
                for (int i = 0; i < linkedList.size(); i++) {
                    tree.insert(fileContents);
                }
            }
        }

        tree.inorderTraversal(writer); //NEED TO PUT THIS LINE INTO A FILE

        System.out.println("Ended");
}